package org.somos.user.repositories;

import org.somos.user.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository para los authorities
 * @author ldosramos
 *
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
