package com.brainyway.mrs.tpms.reports;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.brainyway.mrs.tpms.common.TPMSConstants;
import com.brainyway.mrs.tpms.employee.EmployeeService;
import com.brainyway.mrs.tpms.model.Employee;
import com.brainyway.mrs.tpms.tripdata.TripDataService;

@Controller
public class TPMSReportsController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	TripDataService tripDataService;

	private static final Logger logger = LoggerFactory.getLogger(TPMSReportsController.class);

	   @InitBinder     
		public void initBinder(WebDataBinder binder){
		     binder.registerCustomEditor(  Date.class,     
		                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
		
		}
	   
	   @RequestMapping(value = "/admin/reports/driverkmplform", method = RequestMethod.GET)
		public ModelAndView driverKMPLReportForm() {

			logger.debug("Creating driver KMPL report form ");
			ModelAndView modelView = new ModelAndView();
			
			List<Employee> allDrivers = empService.getAllDrivers(TPMSConstants.DRIVER);
			
			Map<Integer,String> empData = new Hashtable<Integer,String>();

			for(Employee emp:allDrivers){
				
				empData.put(emp.getId(), emp.getFirstName() +" " +emp.getLastName());
			}
			modelView.addObject("empData", empData);
			modelView.setViewName("driverKMPLReportForm");
			
			return modelView;

		}
	   
	   @RequestMapping(value = "/admin/reports/driverkmplview", method = RequestMethod.GET)
		public ModelAndView driverKMPLReportView(WebRequest request) {
		   DriversKMPLCharts driversKMPLCharts = new DriversKMPLCharts();
			logger.debug("Creating driver KMPL report view ");
			String fromDateStr =request.getParameter("fromDate");
			String toDateStr = request.getParameter("toDate");
			String empId = request.getParameter("empId");
			logger.debug("Request values ",empId, fromDateStr,toDateStr);
			ModelAndView modelView = new ModelAndView();
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			
			try {
				
				Date fromDate = formatter.parse(fromDateStr);
				Date toDate = formatter.parse(toDateStr);
				
				Map<String, DriverKMPLChartData> kmplRawDataMap = tripDataService.getDriverKMPLRawData(fromDate,toDate,empId);
				
				if(kmplRawDataMap.isEmpty()){
					
					modelView.addObject("statusMessageKey", "Data Not Found in Selected Range, Please Select a different Range");
					modelView. setViewName("driverKMPLReportView");
					
					return modelView;

				}			
				
				Set<String> buses = kmplRawDataMap.keySet();
				
				List<String> images = new ArrayList<String>();
				
				for (String busRegId : buses) {
				
					DriverKMPLChartData kmplRawData = kmplRawDataMap.get(busRegId);
					kmplRawData.setBusRegistrationNumber(busRegId);
					Employee emp = empService.getEmployeeById(Integer.parseInt(empId));
					File reportFile = driversKMPLCharts.getDriversKMPLCharts(kmplRawData);
					byte[] binaryData = IOUtils.toByteArray(new FileInputStream(reportFile));
			        byte[] encodeBase64 = Base64.encodeBase64(binaryData);
			        String base64Encoded = new String(encodeBase64, "UTF-8");
			         // add outputString to model and show it is on page       
			        images.add(base64Encoded);

				}
				
				 modelView.addObject("driverKMPLReportImagesList", images);
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
				modelView.setViewName("driverKMPLReportView");
			return modelView;

		}
		
}
