package org.somos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the TECHNOLOGYTYPES database table.
 * 
 */
@Entity
@Table(name="TECHNOLOGYTYPES")
@NamedQuery(name="TechnologyType.findAll", query="SELECT t FROM TechnologyType t")
public class TechnologyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int technologyTypeId;

	private String description;

	private String name;

	public TechnologyType() {
	}

	public int getTechnologyTypeId() {
		return this.technologyTypeId;
	}

	public void setTechnologyTypeId(int technologyTypeId) {
		this.technologyTypeId = technologyTypeId;
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

}