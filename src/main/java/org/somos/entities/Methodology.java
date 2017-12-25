package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the METHODOLOGIES database table.
 * 
 */
@Entity
@Table(name="METHODOLOGIES")
@NamedQuery(name="Methodology.findAll", query="SELECT m FROM Methodology m")
public class Methodology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int methodologyId;

	private String description;

	private String name;

	//bi-directional many-to-many association to Project
	@ManyToMany
	@JoinTable(
		name="METHODOLOGIES_PROJECTS"
		, joinColumns={
			@JoinColumn(name="methodologyId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="projectId")
			}
		)
	private List<Project> projects;

	public Methodology() {
	}

	public int getMethodologyId() {
		return this.methodologyId;
	}

	public void setMethodologyId(int methodologyId) {
		this.methodologyId = methodologyId;
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

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}