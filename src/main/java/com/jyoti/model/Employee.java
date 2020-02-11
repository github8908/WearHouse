package com.jyoti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer id;
	@Column(name="ename")
	private String empName;
	@Column(name="esal")
	private String empSal;
	public Employee() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSal() {
		return empSal;
	}
	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empSal=" + empSal + "]";
	}
	

}
