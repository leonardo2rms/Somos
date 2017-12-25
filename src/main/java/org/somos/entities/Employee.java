package org.somos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int employeeId;

	private boolean active;

	private String email;

	private Date endDate;

	private int fileNumber;

	private String firstName;

	private String lastName;

	private boolean lpsPromoted;

	private String observation;

	private String phoneNumber;

	private Date startDate;

	private String workAddress;

	//bi-directional many-to-one association to Costcenter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="costCenterId")
	private CostCenter costcenter;

	//bi-directional many-to-one association to Employeestype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employeeTypeId")
	private EmployeesType employeestype;

	//bi-directional many-to-one association to Laborcharge
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="laborId")
	private LaborCharge laborcharge;

	//bi-directional many-to-one association to Leader
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="laborId")
	private Leader leader;

	//bi-directional many-to-one association to EmployeesTechnology
	@OneToMany(mappedBy="employee")
	private List<EmployeesTechnology> employeesTechnologies;

	//bi-directional many-to-one association to ProjectsEmployee
	@OneToMany(mappedBy="employee")
	private List<ProjectsEmployee> projectsEmployees;

	public Employee() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getFileNumber() {
		return this.fileNumber;
	}

	public void setFileNumber(int fileNumber) {
		this.fileNumber = fileNumber;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLpsPromoted() {
		return this.lpsPromoted;
	}

	public void setLpsPromoted(boolean lpsPromoted) {
		this.lpsPromoted = lpsPromoted;
	}


	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}



	public CostCenter getCostcenter() {
		return this.costcenter;
	}

	public void setCostcenter(CostCenter costcenter) {
		this.costcenter = costcenter;
	}



	public EmployeesType getEmployeestype() {
		return this.employeestype;
	}

	public void setEmployeestype(EmployeesType employeestype) {
		this.employeestype = employeestype;
	}



	public LaborCharge getLaborcharge() {
		return this.laborcharge;
	}

	public void setLaborcharge(LaborCharge laborcharge) {
		this.laborcharge = laborcharge;
	}



	public Leader getLeader() {
		return this.leader;
	}

	public void setLeader(Leader leader) {
		this.leader = leader;
	}



//	public List<EmployeesTechnology> getEmployeesTechnologies() {
//		return this.employeesTechnologies;
//	}
//
//	public void setEmployeesTechnologies(List<EmployeesTechnology> employeesTechnologies) {
//		this.employeesTechnologies = employeesTechnologies;
//	}

//	public EmployeesTechnology addEmployeesTechnology(EmployeesTechnology employeesTechnology) {
//		getEmployeesTechnologies().add(employeesTechnology);
//		employeesTechnology.setEmployee(this);
//
//		return employeesTechnology;
//	}
//
//	public EmployeesTechnology removeEmployeesTechnology(EmployeesTechnology employeesTechnology) {
//		getEmployeesTechnologies().remove(employeesTechnology);
//		employeesTechnology.setEmployee(null);
//
//		return employeesTechnology;
//	}


//	public List<ProjectsEmployee> getProjectsEmployees() {
//		return this.projectsEmployees;
//	}
//
//	public void setProjectsEmployees(List<ProjectsEmployee> projectsEmployees) {
//		this.projectsEmployees = projectsEmployees;
//	}
//
//	public ProjectsEmployee addProjectsEmployee(ProjectsEmployee projectsEmployee) {
//		getProjectsEmployees().add(projectsEmployee);
//		projectsEmployee.setEmployee(this);
//
//		return projectsEmployee;
//	}
//
//	public ProjectsEmployee removeProjectsEmployee(ProjectsEmployee projectsEmployee) {
//		getProjectsEmployees().remove(projectsEmployee);
//		projectsEmployee.setEmployee(null);
//
//		return projectsEmployee;
//	}

}