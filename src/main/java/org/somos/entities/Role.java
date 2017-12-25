package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.somos.user.User;

import java.util.List;


/**
 * The persistent class for the [ROLES] database table.
 * 
 */
@Entity
@Table(name="[ROLES]")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int rolId;

	private String name;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="ROLES_USERS"
		, joinColumns={
			@JoinColumn(name="rolId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="userId")
			}
		)
	private List<User> users;

	public Role() {
	}

	public int getRolId() {
		return this.rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}