package com.brainyway.mrs.tpms.employee;

import java.util.List;

import com.brainyway.mrs.tpms.model.Employee;

public interface EmployeeDAO {

	boolean createEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	Employee getEmployeeByEmpID(String employeeID);
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployees();
	List<Employee> getAllDrivers(String workRole);
	boolean deleteEmployee();
}
