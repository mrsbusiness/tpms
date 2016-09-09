package com.brainyway.mrs.tpms.employee;

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
import com.brainyway.mrs.tpms.model.Employee;
import com.brainyway.mrs.tpms.model.TPMSUser;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO empDAO;	
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public boolean createEmployee(Employee employee) {
		
		empDAO.createEmployee(employee);
		Employee tempEmp = empDAO.getEmployeeById(employee.getId());
		tempEmp.setEmpId(TPMSConstants.EMP_ID_CONST+tempEmp.getId());
		empDAO.updateEmployee(tempEmp);		
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return empDAO.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllDrivers(String workRole) {

		return empDAO.getAllDrivers(workRole);
	}

	@Override
	public boolean deleteEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

}
