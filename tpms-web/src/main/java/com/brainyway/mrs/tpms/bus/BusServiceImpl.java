package com.brainyway.mrs.tpms.bus;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brainyway.mrs.tpms.common.TPMSConstants;
import com.brainyway.mrs.tpms.model.Bus;
import com.brainyway.mrs.tpms.model.TPMSUser;

@Component
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDAO busDAO;	
	
	private static final Logger logger = LoggerFactory.getLogger(BusServiceImpl.class);
	
	
	@Override
	public Bus getBus(String registrationNumber) {
		return busDAO.getBusById(registrationNumber);
	}

	@Override
	public List<Bus> getAllBuses() {
		
		return busDAO.getAllBuses();
		
	}

	@Override
	public boolean deleteBus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createBus(Bus bus) {

		busDAO.createBus(bus);
		
		return true;
	}

	@Override
	public boolean updateBus(Bus bus) {
		// TODO Auto-generated method stub
		return false;
	}

}
