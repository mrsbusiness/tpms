package com.brainyway.mrs.tpms.employee;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brainyway.mrs.tpms.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	 private SessionFactory sessionFactory;


	@Override
	public boolean createEmployee(Employee employee) {

		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		
		return true;
		
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		sessionFactory.getCurrentSession().saveOrUpdate(employee);

		return true;
	}

	@Override
	public Employee getEmployeeByEmpID(String employeeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllDrivers(String workRole) {
		
		String hql = "FROM Employee E WHERE E.workRole = " +"'"+workRole+"'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Employee> employees = query.list();
		
		return employees;
	}

	@Override
	public boolean deleteEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public Employee getEmployeeById(int id) {

		String hql = "FROM Employee E WHERE E.id = " +id;

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Employee> employee = query.list();
		
		if(employee.size()!=1)
			throw new RuntimeException();
		
		return employee.get(0);		
	}

}
