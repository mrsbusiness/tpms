package com.brainyway.mrs.tpms.tripdata;

import java.util.Date;
import java.util.List;

import com.brainyway.mrs.tpms.model.TripData;


public interface TripDataDAO {
	
boolean createTripData(TripData tripdata);
boolean updateTripData(TripData tripdata);
List<TripData> getAllTripDatas(String empId);
List<TripData> getAllOpenTrips();
TripData getTripData(long tripdataId);
List<TripData> getAllTripData(Date fromDate, Date toDate, String empId);
void deleteTripData(long tripId);
List<TripData> getAllTripData(Date fromDate, Date toDate);
int getTodaysTripsCount(Date date);

}

