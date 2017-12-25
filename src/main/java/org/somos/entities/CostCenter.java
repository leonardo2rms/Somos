package org.somos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the COSTCENTERS database table.
 * 
 */
@Entity
@Table(name="COSTCENTERS")
@NamedQuery(name="CostCenter.findAll", query="SELECT c FROM CostCenter c")
public class CostCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int costCenterId;

	private int active;

	private String description;

	public CostCenter() {
	}

	public int getCostCenterId() {
		return this.costCenterId;
	}

	public void setCostCenterId(int costCenterId) {
		this.costCenterId = costCenterId;
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

}