package com.eden.restem.model;

//Generated 13 May, 2024 1:04:40 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
* Employee generated by hbm2java
*/
@Entity
@Table(name = "employee")
//@EntityListeners(AuditingEntityListener.class)
public class Employee implements java.io.Serializable {

	private Integer employeeId;
	private Department department;
	private String name;
	private String email;
	private Date dateOfJoining;
	private String contactNumber;
	private Set<Department> departments = new HashSet<Department>(0);

	public Employee() {
	}

	public Employee(Department department, String name, String email, Date dateOfJoining, String contactNumber,
			Set<Department> departments) {
		this.department = department;
		this.name = name;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.contactNumber = contactNumber;
		this.departments = departments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "employee_id", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_joining", length = 10)
	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Column(name = "contact_number", length = 45)
	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

}