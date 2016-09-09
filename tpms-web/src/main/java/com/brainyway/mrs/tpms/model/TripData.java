package com.brainyway.mrs.tpms.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TripData")

public class TripData {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tripId")
	private long tripId;
		
	@Column(name="tripStartDate")
	private Date tripStartDate;
	
	@Column(name="tripEndDate")
	private Date tripEndDate;
		
	@Column(name="driverStartReportingTime")
	private Date driverStartReportingTime;
	
	@Column(name="driverEndReportingTime")
	private Date driverEndReportingTime;
	
	@Column(name="busStartDepatureTime")
	private Date busStartDepatureTime;
	
	@Column(name="busEndArrivalTime")
	private Date busEndArrivalTime;
	
	@Column(name="startingKMReading")
	private long startingKMReading;
	
	@Column(name="endingKMReading")
	private long endingKMReading;
	
	@Column(name="startingFuelInLtrs")
	private float startingFuelInLtrs;
	
	@Column(name="staringFuelSalesRate")
	private float staringFuelSalesRate;
	
	@Column(name="costOfFuelStarting")
	private float costOfFuelStarting;
	
	@Column(name="costOfAdditionalFuel")
	private float costOfAdditionalFuel;
	
	@Column(name="AdditionalFuel")
	private float AdditionalFuel;
	
	@Column(name="additionalFuelSalesRate")
	private float additionalFuelSalesRate;
	
	@Column(name="tripStartInspectionDriver")
	private String tripStartInspectionDriver;
	
	@Column(name="tripStartInspectionBus")
	private String tripStartInspectionBus;
	
	@Column(name="tripEndInspectionDriver")
	private String tripEndInspectionDriver;
	
	@Column(name="tripEndInspectionBus")
	private String tripEndInspectionBus;
	
	@Column(name="tripStartingRemarks")
	private String tripStartingRemarks;
	
	@Column(name="tripEndingRemarks")
	private String tripEndingRemarks;
	
	@Column(name="KMPL")
	private float KMPL;
	
	@Column(name="recordStatus")
	private String recordStatus;

	public String getStatus() {
		return recordStatus;
	}

	public void setStatus(String status) {
		this.recordStatus = status;
	}

	public float getKMPL() {
		return KMPL;
	}

	public void setKMPL(float kMPL) {
		KMPL = kMPL;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="registrationNumber")
	private Bus bus;
	
	public Date getDriverStartReportingTime() {
		return driverStartReportingTime;
	}

	public void setDriverStartReportingTime(Date driverStartReportingTime) {
		this.driverStartReportingTime = driverStartReportingTime;
	}

	public Date getDriverEndReportingTime() {
		return driverEndReportingTime;
	}

	public void setDriverEndReportingTime(Date driverEndReportingTime) {
		this.driverEndReportingTime = driverEndReportingTime;
	}

	public Date getBusStartDepatureTime() {
		return busStartDepatureTime;
	}

	public void setBusStartDepatureTime(Date busStartDepatureTime) {
		this.busStartDepatureTime = busStartDepatureTime;
	}

	public Date getBusEndArrivalTime() {
		return busEndArrivalTime;
	}

	public void setBusEndArrivalTime(Date busEndArrivalTime) {
		this.busEndArrivalTime = busEndArrivalTime;
	}

	public long getStartingKMReading() {
		return startingKMReading;
	}

	public void setStartingKMReading(long startingKMReading) {
		this.startingKMReading = startingKMReading;
	}

	public float getStartingFuelInLtrs() {
		return startingFuelInLtrs;
	}

	public void setStartingFuelInLtrs(float startingFuelInLtrs) {
		this.startingFuelInLtrs = startingFuelInLtrs;
	}

	public float getStaringFuelSalesRate() {
		return staringFuelSalesRate;
	}

	public void setStaringFuelSalesRate(float staringFuelSalesRate) {
		this.staringFuelSalesRate = staringFuelSalesRate;
	}

	public float getCostOfFuelStarting() {
		return costOfFuelStarting;
	}

	public void setCostOfFuelStarting(float costOfFuelStarting) {
		this.costOfFuelStarting = costOfFuelStarting;
	}

	public float getCostOfAdditionalFuel() {
		return costOfAdditionalFuel;
	}

	public void setCostOfAdditionalFuel(float costOfAdditionalFuel) {
		this.costOfAdditionalFuel = costOfAdditionalFuel;
	}

	public float getAdditionalFuel() {
		return AdditionalFuel;
	}

	public void setAdditionalFuel(float additionalFuel) {
		AdditionalFuel = additionalFuel;
	}

	public float getAdditionalFuelSalesRate() {
		return additionalFuelSalesRate;
	}

	public void setAdditionalFuelSalesRate(float additionalFuelSalesRate) {
		this.additionalFuelSalesRate = additionalFuelSalesRate;
	}

	public String getTripEndingRemarks() {
		return tripEndingRemarks;
	}

	public void setTripEndingRemarks(String tripEndingRemarks) {
		this.tripEndingRemarks = tripEndingRemarks;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="id")
	private Employee employee;
	
	@Transient
	private String empId;
	
	@Transient
	private String busRegId;
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getBusRegId() {
		return busRegId;
	}

	public void setBusRegId(String busRegId) {
		this.busRegId = busRegId;
	}

	public long getTripId() {
		return tripId;
	}

	public void setTripId(long tripId) {
		this.tripId = tripId;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Date getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public Date getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}
	
	public long getEndingKMReading() {
		return endingKMReading;
	}

	public void setEndingKMReading(long endingKMReading) {
		this.endingKMReading = endingKMReading;
	}

	public String getTripStartInspectionDriver() {
		return tripStartInspectionDriver;
	}

	public void setTripStartInspectionDriver(String tripStartInspectionDriver) {
		this.tripStartInspectionDriver = tripStartInspectionDriver;
	}

	public String getTripStartInspectionBus() {
		return tripStartInspectionBus;
	}

	public void setTripStartInspectionBus(String tripStartInspectionBus) {
		this.tripStartInspectionBus = tripStartInspectionBus;
	}

	public String getTripEndInspectionDriver() {
		return tripEndInspectionDriver;
	}

	public void setTripEndInspectionDriver(String tripEndInspectionDriver) {
		this.tripEndInspectionDriver = tripEndInspectionDriver;
	}

	public String getTripEndInspectionBus() {
		return tripEndInspectionBus;
	}

	public void setTripEndInspectionBus(String tripEndInspectionBus) {
		this.tripEndInspectionBus = tripEndInspectionBus;
	}

	public String getTripStartingRemarks() {
		return tripStartingRemarks;
	}

	public void setTripStartingRemarks(String tripStartingRemarks) {
		this.tripStartingRemarks = tripStartingRemarks;
	}
	
	@Column(name="recordTimestamp")
	private Date  recordTimestamp;
	
	public Date getRecordTimestamp() {
		return recordTimestamp;
	}

	public void setRecordTimestamp(Date recordTimestamp) {
		this.recordTimestamp = recordTimestamp;
	}
		
	}
