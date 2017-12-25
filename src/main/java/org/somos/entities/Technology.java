package org.somos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the TECHNOLOGIES database table.
 * 
 */
@Entity
@Table(name="TECHNOLOGIES")
@NamedQuery(name="Technology.findAll", query="SELECT t FROM Technology t")
public class Technology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int technologyId;

	private String description;

	private String name;
	//bi-directional many-to-one association to ProjectsEmployee
	@OneToMany(mappedBy="technology")
	private List<EmployeesTechnology> employeesTechnologies;


	//bi-directional many-to-many association to Profile
	@ManyToMany
	@JoinTable(
		name="PROFILE_TECHNOLOGIES"
		, joinColumns={
			@JoinColumn(name="technologyId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="profileId")
			}
		)
	private List<Profile> profiles;

	//bi-directional many-to-one association to Technologytype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="technologyTypeId")
	private TechnologyType technologytype;

	public Technology() {
	}

	public int getTechnologyId() {
		return this.technologyId;
	}

	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
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

	public List<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public TechnologyType getTechnologytype() {
		return this.technologytype;
	}

	public void setTechnologytype(TechnologyType technologytype) {
		this.technologytype = technologytype;
	}

}