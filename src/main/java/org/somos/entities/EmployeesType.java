package org.somos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the EMPLOYEESTYPES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEESTYPES")
@NamedQuery(name="EmployeesType.findAll", query="SELECT e FROM EmployeesType e")
public class EmployeesType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int employeeTypeId;

	private String description;

	private String name;


	public EmployeesType() {
	}

	public int getEmployeeTypeId() {
		return this.employeeTypeId;
	}

	public void setEmployeeTypeId(int employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
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