package org.somos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the BUSINESSCATEGORIES database table.
 * 
 */
@Entity
@Table(name="BUSINESSCATEGORIES")
@NamedQuery(name="BusinessCategory.findAll", query="SELECT b FROM BusinessCategory b")
public class BusinessCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int businessCategoryId;

	private boolean active;

	private String name;

	public BusinessCategory() {
	}

	public int getBusinessCategoryId() {
		return this.businessCategoryId;
	}

	public void setBusinessCategoryId(int businessCategoryId) {
		this.businessCategoryId = businessCategoryId;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}