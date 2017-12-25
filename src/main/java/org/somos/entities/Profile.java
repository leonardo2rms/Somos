package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROFILES database table.
 * 
 */
@Entity
@Table(name="PROFILES")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int profileId;

	private String acronym;

	private int active;

	private String description;

	private String name;

	private String task;

	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectId")
	private Project project;

	//bi-directional many-to-many association to ProjectsEmployee
	@ManyToMany(mappedBy="profiles")
	private List<ProjectsEmployee> projectsEmployees;

	//bi-directional many-to-many association to Technology
	@ManyToMany(mappedBy="profiles")
	private List<Technology> technologies;

	public Profile() {
	}

	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<ProjectsEmployee> getProjectsEmployees() {
		return this.projectsEmployees;
	}

	public void setProjectsEmployees(List<ProjectsEmployee> projectsEmployees) {
		this.projectsEmployees = projectsEmployees;
	}

	public List<Technology> getTechnologies() {
		return this.technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

}