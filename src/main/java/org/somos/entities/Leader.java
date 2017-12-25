package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LEADER database table.
 * 
 */
@Entity
@Table(name="LEADER")
@NamedQuery(name="Leader.findAll", query="SELECT l FROM Leader l")
public class Leader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int leaderId;

	private boolean active;

	private String firstName;

	private boolean intern;

	private String lastName;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="leader")
	private List<Employee> employees;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="leader")
	private List<Project> projects;

	public Leader() {
	}

	public int getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean getIntern() {
		return this.intern;
	}

	public void setIntern(boolean intern) {
		this.intern = intern;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setLeader(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setLeader(null);

		return employee;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setLeader(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setLeader(null);

		return project;
	}

}