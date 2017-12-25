package org.somos.user.web.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.somos.user.Authority;
import org.somos.user.User;
import org.somos.utils.Constants;

import javax.validation.constraints.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * DTO que representa a un usuario
 * @author ldosramos
 *
 */
public class UserDTO {

	private Long id;

	@NotBlank
	@Pattern(regexp = Constants.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	private String login;
	private boolean activated = false;

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}

	private Set<String> authorities;

	public UserDTO() {
		// Empty constructor needed for Jackson.
	}

	public UserDTO(User user) {
		this(user.getLogin(), user.getActivated(),
				user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
	}
	
	public UserDTO(Optional<User> user) {
			this(user.get().getLogin(), user.get().getActivated(),
				user.get().getAuthorities()
				.stream()
				.map(Authority::getName).collect(Collectors.toSet()));
	}

	public UserDTO(String login, boolean activated, Set<String> authorities) {
		this.login = login;
		this.activated = activated;
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Set<String> getAuthorities() {
		return authorities;
	}

	@Override
	public String toString() {
		return "UserDTO{" + "login='" + login + '\'' 
				+ ", activated=" + activated 
				+ ", authorities=" + authorities
				+ "}";
	}
}
