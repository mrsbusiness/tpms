package com.brainyway.mrs.tpms.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="driver")
public class Driver extends Employee {
	
	private String licenseNumber;
	private String badgeNumber;

}
