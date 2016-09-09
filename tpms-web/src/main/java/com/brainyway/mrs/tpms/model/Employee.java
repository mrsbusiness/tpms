package com.brainyway.mrs.tpms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="empId")
	private String empId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;	

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "experience")
	private float experience;
	
	@Column(name = "eMail")
	private String eMail;
	
	@Column(name = "joiningDate")
	private Date joiningDate;
	
	@Column(name = "panNumber")
	private String panNumber;
	
	@Column(name = "adarCardNumber")
	private String adarCardNumber;
	
	@Column(name = "currentAddress")
	private String currentAddress;
	
	@Column(name = "permAddress")
	private String permAddress;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "martialStatus")
	private String martialStatus;
	
	@Column(name= "homePhoneNumber")
	private long homePhoneNumber;
 
	@Column(name= "cellPhoneNumber")
	private long cellPhoneNumber;
	
	@Column(name="licenseNumber")
	private String licenseNumber;
	
	@Column(name="badgeNumber")
	private String badgeNumber;
	
	@Column(name="workRole")
	private String workRole;
	
	@Column(name="recordTimestamp")
	private Date  recordTimestamp;
	
	@Column(name="recordStatus")
	private String recordStatus;
		
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	
	public Date getRecordTimestamp() {
		return recordTimestamp;
	}

	public void setRecordTimestamp(Date recordTimestamp) {
		this.recordTimestamp = recordTimestamp;
	}
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	public String getWorkRole() {
		return workRole;
	}

	public void setWorkRole(String workRole) {
		this.workRole = workRole;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public long getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(long homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public long getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(long cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}



	public String getAdarCardNumber() {
		return adarCardNumber;
	}

	public void setAdarCardNumber(String adarCardNumber) {
		this.adarCardNumber = adarCardNumber;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	@Override
	public String toString(){
		
		return "Name: "+this.getFirstName()+"  "+this.getLastName()+" Employee Ic"+this.getEmpId();
	}
}
