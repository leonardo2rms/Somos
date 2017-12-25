package org.somos.security;

import org.springframework.security.core.AuthenticationException;


/**
 * Clase manejadora de excepción para usuario inactivo
 * 
 * @author ldosramos
 *
 */
public class UserNotActivatedException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public UserNotActivatedException(String message) {
        super(message);
    }

    public UserNotActivatedException(String message, Throwable t) {
        super(message, t);
    }
}
