package com.klef.jfsd.exam.DemoHibernateProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="department_table")
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(name="department_name",length = 100,nullable = false)
	private String Name;
	@Column(name="department_location",length = 100,nullable = false)
	private String Location;
	@Column(name="department_hod",length = 100,nullable = false)
	private String HodName;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getHodName() {
		return HodName;
	}
	public void setHodName(String hodName) {
		HodName = hodName;
	}
	
}
