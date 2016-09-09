package com.brainyway.mrs.tpms.tripdata;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.brainyway.mrs.tpms.model.TripData;
import com.brainyway.mrs.tpms.reports.DriverKMPLChartData;

public interface TripDataService {

	boolean createTripData(TripData tripdata);
	boolean updateTripData(TripData tripdata);
	TripData getTripData(long tripdataId);
	boolean deleteTripData(long tripId);
	List<TripData> getAllOpenTrips();
	Map<String, DriverKMPLChartData> getDriverKMPLRawData(Date fromDate, Date toDate,
			String empId);
	List<TripData> getTripDataForDriver(Date fromDate, Date toDate,
			String empId);
	
	List<TripData> getAllTripData(Date fromDate, Date toDate);
	int getTodaysTripsCount(Date date);
}
