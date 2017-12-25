package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PROJECTS database table.
 * 
 */
@Entity
@Table(name="PROJECTS")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int projectId;

	private boolean active;

	private String area;

	private String beneficiary;

	private String crm;

	private Date endDate;

	private String functionalRequirement;

	private boolean internal;

	private String jira;

	private boolean lpsPromoted;

	private String name;

	private String observation;

	private String role;

	private Date starDate;

	private String target;

	//bi-directional many-to-many association to Methodology
	@ManyToMany(mappedBy="projects")
	private List<Methodology> methodologies;

	//bi-directional many-to-one association to Profile
	@OneToMany(mappedBy="project")
	private List<Profile> profiles;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clientId")
	private Client client;

	//bi-directional many-to-one association to Leader
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="leaderId")
	private Leader leader;

	//bi-directional many-to-one association to ProjectsEmployee
	@OneToMany(mappedBy="project")
	private List<ProjectsEmployee> projectsEmployees;

	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public String getCrm() {
		return this.crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFunctionalRequirement() {
		return this.functionalRequirement;
	}

	public void setFunctionalRequirement(String functionalRequirement) {
		this.functionalRequirement = functionalRequirement;
	}

	public boolean getInternal() {
		return this.internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	public String getJira() {
		return this.jira;
	}

	public void setJira(String jira) {
		this.jira = jira;
	}

	public boolean getLpsPromoted() {
		return this.lpsPromoted;
	}

	public void setLpsPromoted(boolean lpsPromoted) {
		this.lpsPromoted = lpsPromoted;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getStarDate() {
		return this.starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<Methodology> getMethodologies() {
		return this.methodologies;
	}

	public void setMethodologies(List<Methodology> methodologies) {
		this.methodologies = methodologies;
	}

	public List<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public Profile addProfile(Profile profile) {
		getProfiles().add(profile);
		profile.setProject(this);

		return profile;
	}

	public Profile removeProfile(Profile profile) {
		getProfiles().remove(profile);
		profile.setProject(null);

		return profile;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Leader getLeader() {
		return this.leader;
	}

	public void setLeader(Leader leader) {
		this.leader = leader;
	}

	public List<ProjectsEmployee> getProjectsEmployees() {
		return this.projectsEmployees;
	}

	public void setProjectsEmployees(List<ProjectsEmployee> projectsEmployees) {
		this.projectsEmployees = projectsEmployees;
	}

	public ProjectsEmployee addProjectsEmployee(ProjectsEmployee projectsEmployee) {
		getProjectsEmployees().add(projectsEmployee);
		projectsEmployee.setProject(this);

		return projectsEmployee;
	}

	public ProjectsEmployee removeProjectsEmployee(ProjectsEmployee projectsEmployee) {
		getProjectsEmployees().remove(projectsEmployee);
		projectsEmployee.setProject(null);

		return projectsEmployee;
	}

}