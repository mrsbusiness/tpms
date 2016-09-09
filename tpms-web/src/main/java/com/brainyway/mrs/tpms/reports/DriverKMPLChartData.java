package com.brainyway.mrs.tpms.reports;

import java.util.List;

import com.brainyway.mrs.tpms.model.Bus;
import com.brainyway.mrs.tpms.model.Employee;

public class DriverKMPLChartData {
	
	private Employee employee;
	private List<DriverKMPL> driverKMPLList;
	private String busRegistrationNumber;
	
	public String getBusRegistrationNumber() {
		return busRegistrationNumber;
	}

	public void setBusRegistrationNumber(String busRegistrationNumber) {
		this.busRegistrationNumber = busRegistrationNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getDriverName() {
		return employee;
	}

	public void setDriverName(Employee employee) {
		this.employee = employee;
	}

	public List<DriverKMPL> getDriverKMPLList() {
		return driverKMPLList;
	}

	public void setDriverKMPLList(List<DriverKMPL> driverKMPLList) {
		this.driverKMPLList = driverKMPLList;
	}

}
