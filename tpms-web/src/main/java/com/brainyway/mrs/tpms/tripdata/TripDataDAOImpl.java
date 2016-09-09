package com.brainyway.mrs.tpms.tripdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brainyway.mrs.tpms.common.TPMSConstants;
import com.brainyway.mrs.tpms.model.TripData;

@Repository
@Transactional
public class TripDataDAOImpl implements TripDataDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createTripData(TripData tripdata) {

		sessionFactory.getCurrentSession().saveOrUpdate(tripdata);

		return true;
	}

	@Override
	public boolean updateTripData(TripData tripdata) {

		sessionFactory.getCurrentSession().update(tripdata);

		return true;
	}

	@Override
	public List<TripData> getAllTripDatas(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripData> getAllOpenTrips() {

		String hql = "FROM TripData T WHERE T.recordStatus is ? and (T.endingKMReading is null or T.KMPL=0)";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, TPMSConstants.OPEN_STATUS);
		return query.list();

	}

	@Override
	public TripData getTripData(long tripdataId) {

		String hql = "FROM TripData T WHERE T.tripId=" + tripdataId;

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<TripData> tripList = query.list();
		if (tripList.size() != 1) {
			throw new RuntimeException();
		}
		return tripList.get(0);

	}

	@Override
	public List<TripData> getAllTripData(Date fromDate, Date toDate,
			String empId) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String hql = "FROM TripData T where T.employee.id=" + empId+ " and T.tripStartDate BETWEEN ? AND ?";
		
		
		/*String hql = "FROM TripData T where T.employee.id=" + empId
				+ " and (T.tripStartDate >= " + formatter.format(fromDate)
				+ " and T.tripStartDate <=" + formatter.format(toDate) + ")";*/

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate(0, fromDate);
		query.setDate(1, toDate);

		List<TripData> tripList = query.list();

		return tripList;

	}
	
	@Override
	public List<TripData> getAllTripData(Date fromDate, Date toDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String hql = "FROM TripData T where T.tripStartDate BETWEEN ? AND ?";
		
		
		/*String hql = "FROM TripData T where T.employee.id=" + empId
				+ " and (T.tripStartDate >= " + formatter.format(fromDate)
				+ " and T.tripStartDate <=" + formatter.format(toDate) + ")";*/

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate(0, fromDate);
		query.setDate(1, toDate);

		List<TripData> tripList = query.list();

		return tripList;

	}

	@Override
	public void deleteTripData(long tripId) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("");
		
	}

	@Override
	public int getTodaysTripsCount(Date todayDate) {
		
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String hql = "FROM TripData T where T.tripStartDate is ?";
		
		
		/*String hql = "FROM TripData T where T.employee.id=" + empId
				+ " and (T.tripStartDate >= " + formatter.format(fromDate)
				+ " and T.tripStartDate <=" + formatter.format(toDate) + ")";*/

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate(0, todayDate);

		return query.list().size();

		

		
	}

}
