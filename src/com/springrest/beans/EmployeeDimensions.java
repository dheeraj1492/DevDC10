package com.springrest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
   @Entity
   @Table(name = "EmployeeDimensions")
public class EmployeeDimensions {
	   @Id
	   @Column(name = "id")
	   private int id;

	   @Column(name = "name")
	   private String name;

	   @Column(name = "joblevel")
	   private String joblevel;

	   @Column(name = "department")
	   private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}  
}
