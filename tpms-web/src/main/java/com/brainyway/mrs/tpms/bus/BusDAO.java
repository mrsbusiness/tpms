package com.brainyway.mrs.tpms.bus;

import java.util.List;

import com.brainyway.mrs.tpms.model.Bus;

public interface BusDAO {

	boolean createBus(Bus bus);
	boolean updateBus(Bus bus);
	Bus getBusById(String registrationNumber);
	
	List<Bus> getAllBuses();
	
	boolean deleteBus();
}
