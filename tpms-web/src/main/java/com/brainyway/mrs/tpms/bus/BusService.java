package com.brainyway.mrs.tpms.bus;

import java.util.List;

import com.brainyway.mrs.tpms.model.Bus;

public interface BusService {

	boolean createBus(Bus bus);
	boolean updateBus(Bus bus);
	Bus getBus(String busId);
	List<Bus> getAllBuses();
	boolean deleteBus();
}
