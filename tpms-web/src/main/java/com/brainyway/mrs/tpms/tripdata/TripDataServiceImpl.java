package com.brainyway.mrs.tpms.tripdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainyway.mrs.tpms.model.TripData;
import com.brainyway.mrs.tpms.reports.DriverKMPL;
import com.brainyway.mrs.tpms.reports.DriverKMPLChartData;
import com.mysql.fabric.xmlrpc.base.Array;

@Component
public class TripDataServiceImpl implements TripDataService {

	@Autowired
	public TripDataDAO tripDataDao; 
	
	@Override
	public boolean createTripData(TripData tripdata) {
		
		tripDataDao.createTripData(tripdata);
		return true;
		
	}

	@Override
	public boolean updateTripData(TripData tripdata) {

		tripDataDao.updateTripData(tripdata);
		return true;
	}

	@Override
	public TripData getTripData(long tripdataId) {
		return tripDataDao.getTripData(tripdataId);
		
	}

	@Override
	public boolean deleteTripData(long tripId) {
		
		tripDataDao.deleteTripData(tripId);
		return true;
	}

	@Override
	public List<TripData> getAllOpenTrips() {
		
		return tripDataDao.getAllOpenTrips();
		
	}

	@Override
	public Map<String, DriverKMPLChartData> getDriverKMPLRawData(Date fromDate,
			Date toDate, String empId) {
		
		Map<String, DriverKMPLChartData> empBusTripData = new HashMap<String, DriverKMPLChartData>();
		
		List<TripData> tripData = tripDataDao.getAllTripData(fromDate,toDate,empId);
		
		List<DriverKMPL> driverKMPLList = new ArrayList<DriverKMPL>();

		for(TripData tempTripData:tripData){
			
			DriverKMPL e = new DriverKMPL();
			e.setDayOfKMPL(tempTripData.getTripStartDate());
			e.setKmpl(tempTripData.getKMPL());
			driverKMPLList.add(e );
		    DriverKMPLChartData busChartData = empBusTripData.get(tempTripData.getBus().getRegistrationNumber());

			 if(busChartData!=null){
				 
				  busChartData.getDriverKMPLList().add(e);
			
			 } else{
				 
				 	DriverKMPLChartData driverKMPLData = new DriverKMPLChartData();
					List<DriverKMPL> tempKMPLList = new ArrayList<DriverKMPL>();
					tempKMPLList.add(e);
					driverKMPLData.setDriverKMPLList(tempKMPLList);
					driverKMPLData.setBusRegistrationNumber(tempTripData.getBus().getRegistrationNumber());
					driverKMPLData.setEmployee(tempTripData.getEmployee());
					empBusTripData.put(tempTripData.getBus().getRegistrationNumber(), driverKMPLData);
			 }
		    
		}
		
		return empBusTripData ;
	}

	@Override
	public List<TripData> getTripDataForDriver(Date fromDate, Date toDate,
			String empId) {
		List<TripData> tripData = tripDataDao.getAllTripData(fromDate,toDate,empId);

		return tripData;
	}
	
	@Override
	public List<TripData> getAllTripData(Date fromDate, Date toDate) {
		List<TripData> tripData = tripDataDao.getAllTripData(fromDate,toDate);

		return tripData;
	}

	@Override
	public int getTodaysTripsCount(Date date) {
		
		return tripDataDao.getTodaysTripsCount(date);
		
	}
}
	
