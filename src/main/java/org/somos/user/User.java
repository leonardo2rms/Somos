package org.somos.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.somos.entities.Employee;
import org.somos.entities.Role;
import org.somos.utils.Constants;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
	private String login;

	@NotNull
	private boolean activated;

	private String description;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private Employee employee;
	
	//bi-directional many-to-many association to Role
  	@ManyToMany(mappedBy="users")
  	private List<Role> roles;

  	
  	@JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "AUTORITIES_USERS",
        joinColumns = {@JoinColumn(name = "userLogin", referencedColumnName = "login")},
        inverseJoinColumns = {@JoinColumn(name = "nameAuthority", referencedColumnName = "name")})

    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();
	
  	public User() {
	}

	public String getLogin() {
		return this.login;
	}

	//Lowercase the login before saving it in database
    public void setLogin(String login) {
        this.login = StringUtils.lowerCase(login, Locale.ENGLISH);
    }

	public boolean getActivated() {
		return this.activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return !(user.getLogin() == null || getLogin() == null) && Objects.equals(getLogin(), user.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLogin());
    }

    @Override
    public String toString() {
        return "User{" +
            "login='" + login + '\'' +
            ", activated='" + activated + '\'' +
            "}";
    }

}