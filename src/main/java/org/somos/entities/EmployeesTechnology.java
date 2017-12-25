package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLOYEES_TECHNOLOGIES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES_TECHNOLOGIES")
@NamedQuery(name="EmployeesTechnology.findAll", query="SELECT e FROM EmployeesTechnology e")
public class EmployeesTechnology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int employeesTecnologiesId;

	private int seniority;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private Employee employee;

	//bi-directional many-to-one association to Technology
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="technologyId")
	private Technology technology;

	public EmployeesTechnology() {
	}

	public int getEmployeesTecnologiesId() {
		return this.employeesTecnologiesId;
	}

	public void setEmployeesTecnologiesId(int employeesTecnologiesId) {
		this.employeesTecnologiesId = employeesTecnologiesId;
	}

	public int getSeniority() {
		return this.seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

}