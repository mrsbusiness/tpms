package com.brainyway.mrs.tpms.bus;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brainyway.mrs.tpms.model.Bus;

@Repository
@Transactional
public class BusDAOImpl implements BusDAO {
	
	@Autowired
	 private SessionFactory sessionFactory;


	@Override
	public boolean createBus(Bus bus) {

		sessionFactory.getCurrentSession().saveOrUpdate(bus);
		
		return true;
		
	}

	@Override
	public boolean updateBus(Bus bus) {

		sessionFactory.getCurrentSession().saveOrUpdate(bus);

		return true;
	}

	@Override
	public List<Bus> getAllBuses() {

		String hql = "FROM Bus B ";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return  query.list();

	}

	
	@SuppressWarnings({ "unchecked"})
	@Override
	public Bus getBusById(String registrationNumber) {

		String hql = "FROM Bus B WHERE B.registrationNumber = '" +registrationNumber+"'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Bus> bus = query.list();
		
		if(bus.size()!=1)
			throw new RuntimeException("Number of Buses are not as expted, expected 1 but  saw" + bus.size());
		
		return bus.get(0);		
	}

	@Override
	public boolean deleteBus() {
		// TODO Auto-generated method stub
		return false;
	}

}
