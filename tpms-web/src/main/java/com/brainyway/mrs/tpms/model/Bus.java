package com.brainyway.mrs.tpms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bus")
public class Bus {
	
	@Id
	@Column(name="registrationNumber")
	private String registrationNumber;
	
	@Column(name="engineNumber")
	private String engineNumber;
	
	@Column(name="chasisNumber")
	private String chasisNumber;
	
	@Column(name="insurancePolicyNumber")
	private String insurancePolicyNumber;
	
	@Column(name="policyExpiryDate")
	private Date policyExpiryDate;
	
	@Column(name="roadTaxDate")
	private Date roadTaxDate;
	
	@Column(name="busType")
	private String busType;
	
	@Column(name="busRoute")
	private String busRoute ;
	
	@Column(name="busDepot")
	private String busDepot ;
	
	@Column(name="finance")
	private String finance  ;
	
	@Column(name="kilometers")
	private int kilometers ;
	
	@Column(name="ratePerKilometers")
	private double ratePerKilometers ;
	
	@Column(name="bodyMaker")
	private String bodyMaker  ;
	
	@Column(name="dieselPerDayLiters")
	private int dieselPerDayLiters ;
	
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
	
	public int getDieselPerDayLiters() {
		return dieselPerDayLiters;
	}

	public void setDieselPerDayLiters(int dieselPerDayLiters) {
		this.dieselPerDayLiters = dieselPerDayLiters;
	}

	public double getRatePerKilometers() {
		return ratePerKilometers;
	}

	public void setRatePerKilometers(double ratePerKilometers) {
		this.ratePerKilometers = ratePerKilometers;
	}

	public String getBodyMaker() {
		return bodyMaker;
	}

	public void setBodyMaker(String bodyMaker) {
		this.bodyMaker = bodyMaker;
	}

	public int getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getChasisNumber() {
		return chasisNumber;
	}

	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public Date getPolicyExpiryDate() {
		return policyExpiryDate;
	}

	public void setPolicyExpiryDate(Date policyExpiryDate) {
		this.policyExpiryDate = policyExpiryDate;
	}

	public Date getRoadTaxDate() {
		return roadTaxDate;
	}

	public void setRoadTaxDate(Date roadTaxDate) {
		this.roadTaxDate = roadTaxDate;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(String busRoute) {
		this.busRoute = busRoute;
	}

	public String getFinance() {
		return finance;
	}

	public String getBusDepot() {
		return busDepot;
	}

	public void setBusDepot(String busDepot) {
		this.busDepot = busDepot;
	}

	public void setFinance(String finance) {
		this.finance = finance;
	}
	
	public String toString(){
		
		return this.getRegistrationNumber()+this.getEngineNumber();
	}

}
