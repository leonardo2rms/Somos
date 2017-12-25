package org.somos.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.somos.user.User;
import org.somos.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl.Essence;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase encargada de obtener la autenticación del usuario de LDAP y el respoitorio de Somos
 * ldosramos
 */
public class CustomUserDetailsContextMapper extends LdapUserDetailsMapper {

    
	private final Logger log = LoggerFactory.getLogger(CustomUserDetailsContextMapper.class);
	@Autowired
	private UserRepository userRepository;

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        LdapUserDetails userDetails = (LdapUserDetails) super.mapUserFromContext(ctx, username, authorities);

        Essence essence = new LdapUserDetailsImpl.Essence();
        log.debug("Authenticating {}", userDetails.getUsername());
        essence.setDn(userDetails.getDn());
        essence.setUsername(userDetails.getUsername());
        essence.setPassword(userDetails.getPassword());
        String lowercaseLogin = userDetails.getUsername().toLowerCase();
        Optional<User> userFromDatabase = userRepository.findOneWithAuthoritiesByLogin(lowercaseLogin);
//        if(userFromDatabase.isPresent()) {
//        	if (!userFromDatabase.get().getActivated()){
//        		throw new UserNotActivatedException("El Usuario " + lowercaseLogin + " esta inhabilitado");
//        	}
//        	essence.setAuthorities(userFromDatabase.get().getAuthorities().stream()
//        			.map(authority -> new SimpleGrantedAuthority(authority.getName()))
//        			.collect(Collectors.toList()));
//        	return essence.createUserDetails();
//        }else {
//        	throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " + "database");
//        }
        return userFromDatabase.map(user -> ldapUserDetails(essence, lowercaseLogin, user))
        		.orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " +
        "database"));
//        
    }

	private LdapUserDetails ldapUserDetails(Essence essence, String lowercaseLogin, User user) {
		if (!user.getActivated()) {
		    throw new UserNotActivatedException("El Usuario " + lowercaseLogin + " esta inhabilitado");
		}
		essence.setAuthorities(user.getAuthorities().stream()
		        .map(authority -> new SimpleGrantedAuthority(authority.getName()))
		        .collect(Collectors.toList()));
		return essence.createUserDetails();
	}
}
