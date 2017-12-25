package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PROJECTS_EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="PROJECTS_EMPLOYEES")
@NamedQuery(name="ProjectsEmployee.findAll", query="SELECT p FROM ProjectsEmployee p")
public class ProjectsEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int projecEmployeeId;

	private Date endDate;

	private int lpsYear;

	private Date reviewDate;

	private Date startDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private Employee employee;
	
	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectId")
	private Project project;

	//bi-directional many-to-many association to Profile
	@ManyToMany
	@JoinTable(
		name="PROFILE_PROJECTS_EMPLOYEES"
		, joinColumns={
			@JoinColumn(name="projecEmployeeId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="profileId")
			}
		)
	private List<Profile> profiles;

	public ProjectsEmployee() {
	}

	public int getProjecEmployeeId() {
		return this.projecEmployeeId;
	}

	public void setProjecEmployeeId(int projecEmployeeId) {
		this.projecEmployeeId = projecEmployeeId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getLpsYear() {
		return this.lpsYear;
	}

	public void setLpsYear(int lpsYear) {
		this.lpsYear = lpsYear;
	}

	public Date getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}