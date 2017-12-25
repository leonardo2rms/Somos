package org.somos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the LABORCHARGES database table.
 * 
 */
@Entity
@Table(name="LABORCHARGES")
@NamedQuery(name="LaborCharge.findAll", query="SELECT l FROM LaborCharge l")
public class LaborCharge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int laborId;

	private boolean active;

	private String desription;

	public LaborCharge() {
	}

	public int getLaborId() {
		return this.laborId;
	}

	public void setLaborId(int laborId) {
		this.laborId = laborId;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDesription() {
		return this.desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

}