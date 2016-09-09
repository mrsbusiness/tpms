package com.brainyway.mrs.tpms.employee;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.brainyway.mrs.tpms.common.TPMSConstants;
import com.brainyway.mrs.tpms.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/* *//**
     * For every request for this controller, this will 
     * create a employee instance for the form.
     *//*
    @ModelAttribute(value="employee")
    public Employee newRequest(@RequestParam(required=false) Employee emp) {
    	
    	if(emp != null){
    		
    		logger.debug("ID and EmpID",emp.getId(),emp.getEmpId());
    		 return emp;
    		 
    	} else{
    	
    		emp = new Employee();
    		return emp;
    		
    	}
    	
        
    }
*/
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(  Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	@RequestMapping(value = "/admin/employee/create", method = RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute("employee")Employee employee, WebRequest request) {

		logger.debug("Employee Data: " + employee); 
		empService.createEmployee(employee);
		employee.setEmpId(TPMSConstants.EMP_ID_CONST+employee.getId());
		empService.updateEmployee(employee);
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("statusMessageKey", "Employee Has been Created successfully");
		modelView.setViewName("successPage");
		request.removeAttribute("employee",0);
		return modelView;

	}
	
	@RequestMapping(value = "/admin/employee/form", method = RequestMethod.GET)
	public ModelAndView createEmployeeForm(@ModelAttribute("employee")Employee employee) {

		ModelAndView model = new ModelAndView();
		model.setViewName("newEmployeeForm");
		return model;

	}
}
