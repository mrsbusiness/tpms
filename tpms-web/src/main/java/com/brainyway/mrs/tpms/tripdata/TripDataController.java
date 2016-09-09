package com.brainyway.mrs.tpms.tripdata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.brainyway.mrs.tpms.bus.BusService;
import com.brainyway.mrs.tpms.common.TPMSConstants;
import com.brainyway.mrs.tpms.employee.EmployeeService;
import com.brainyway.mrs.tpms.model.Bus;
import com.brainyway.mrs.tpms.model.Employee;
import com.brainyway.mrs.tpms.model.TripData;

@Controller
public class TripDataController {

	@Autowired
	TripDataService tripDataService;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	BusService busService;

	private static final Logger logger = LoggerFactory.getLogger(TripDataController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		  DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		  CustomDateEditor cde1 = new CustomDateEditor(dateFormat1, true);
		  DateFormat timeFormat = new SimpleDateFormat("hh:mm");
		  CustomDateEditor cde2 = new CustomDateEditor(timeFormat, true);
		  binder.registerCustomEditor(Date.class, "tripStartDate", cde1);
		  binder.registerCustomEditor(Date.class, "driverStartReportingTime", cde2);
		  binder.registerCustomEditor(Date.class, "busStartDepatureTime", cde2);
		  binder.registerCustomEditor(Date.class, "tripEndDate", cde1);
		  binder.registerCustomEditor(Date.class, "driverEndReportingTime", cde2);
		  binder.registerCustomEditor(Date.class, "busEndArrivalTime", cde2);
			
	}

	
	
	@RequestMapping(value="/admin/trip/open/create",method = RequestMethod.POST)
	public ModelAndView createTripData(@ModelAttribute("tripOpenData")TripData tripdata, WebRequest request){
	
		String regNumber = tripdata.getBusRegId();
		tripdata.setBus(busService.getBus(regNumber));
		
		String id = tripdata.getEmpId();
		Employee emp = empService.getEmployeeById(Integer.parseInt(id));
		tripdata.setEmployee(emp);
		tripdata.setStatus(TPMSConstants.OPEN_STATUS);
		tripDataService.createTripData(tripdata);

		
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("statusMessageKey", "Trip Data Has been Created successfully");
		modelView.setViewName("successPage");
		return modelView;
		
		
	}
	
	
	@RequestMapping(value="/admin/trip/close/create",method = RequestMethod.POST)
	public String createClosingTripData(@ModelAttribute("tripCheckOutData")TripData tripdata, WebRequest request){
	
		String regNumber = tripdata.getBusRegId();
		tripdata.setBus(busService.getBus(regNumber));
		logger.debug("The Bus Registration Number",regNumber); 
		
		String id = tripdata.getEmpId();
		Employee emp = empService.getEmployeeById(Integer.parseInt(id));
		tripdata.setEmployee(emp);
		logger.debug("Employee Id",id);
		if(tripdata.getStartingFuelInLtrs()+tripdata.getAdditionalFuel()<=0){
		
			tripdata.setKMPL(0);
			
		} else{
		
			float kmpl = (tripdata.getEndingKMReading()-tripdata.getStartingKMReading())/(tripdata.getStartingFuelInLtrs()+tripdata.getAdditionalFuel());
			tripdata.setKMPL(kmpl);
		}
		if(tripdata.getKMPL() >0){
			tripdata.setStatus(TPMSConstants.CLOSE_STATUS);
		} else{
			
			tripdata.setStatus(TPMSConstants.OPEN_STATUS);
		}
		tripDataService.updateTripData(tripdata);

		
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("statusMessageKey", "Trip Data Has been Created successfully");
		modelView.setViewName("openTripsView");
		return "redirect:../openstate";
		
		
	}
	
	@RequestMapping(value = "/admin/trip/open/form", method = RequestMethod.GET)
	public ModelAndView createTripOpenForm(
			@ModelAttribute("tripOpenData") TripData tripdata) {
		ModelAndView model = new ModelAndView();
		List<Employee> allEmployee = empService.getAllDrivers("Driver");
		
		List<Bus> allBuses = busService.getAllBuses();
		model.addObject("busesForJSP",allBuses);
		model.addObject("employees", allEmployee);
		model.setViewName("tripCheckInForm");
		return model;

	}
	
	@RequestMapping(value = "/admin/trip/close/form", method = RequestMethod.GET)
	public ModelAndView createTripCloseForm(
			@ModelAttribute("tripCheckOutData") TripData tripdata,WebRequest request) {
		
		ModelAndView model = new ModelAndView();
		tripdata = tripDataService.getTripData(Long.parseLong(request.getParameter("tripId")));
		tripdata.setBus(busService.getBus(request.getParameter("busRegId")));
		tripdata.setEmployee(empService.getEmployeeById(Integer.parseInt(request.getParameter("empId"))));
		model.addObject("tripCheckOutData", tripdata);
		model.setViewName("tripCheckOutForm");
		return model;

	}
	
	@RequestMapping(value = "/admin/trip/openstate", method = RequestMethod.GET)
	public ModelAndView openStateTripsView(
			@ModelAttribute("tripCheckOutData") TripData tripdata) {
		
		ModelAndView model = new ModelAndView();
		List<TripData> openTrips = tripDataService.getAllOpenTrips();
		model.addObject("openTrips", openTrips);
		model.setViewName("openTripsView");
		return model;

	}
	
	@RequestMapping(value = "/admin/trip/alltrips/form", method = RequestMethod.GET)
	public ModelAndView allTripsViewForm() {
		

		ModelAndView model = new ModelAndView();
		model.setViewName("allTripsViewForm");
		return model;

	}
	
	@RequestMapping(value = "/admin/trip/alltrips/view", method = RequestMethod.GET)
	public ModelAndView allTripsView(
			@ModelAttribute("tripCheckOutData") TripData tripdata, WebRequest request) {
		
		String fromDateStr =request.getParameter("fromDate");
		String toDateStr = request.getParameter("toDate");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = formatter.parse(fromDateStr);
			toDate = formatter.parse(toDateStr);

		} catch (ParseException e) {
			logger.error("Error parsing dates for all trips data",e);
		}
		ModelAndView model = new ModelAndView();
		List<TripData> openTrips = tripDataService.getAllTripData(fromDate, toDate);
		model.addObject("openTrips", openTrips);
		model.setViewName("allTripsView");
		return model;

	}
	
	@RequestMapping(value = "/admin/trip/delete", method = RequestMethod.POST)
	public String deleteTrip(
			@ModelAttribute("tripCheckOutData") TripData tripdata,WebRequest request) {
		
		tripdata = tripDataService.getTripData(Long.parseLong(request.getParameter("tripId")));
		tripdata.setStatus(TPMSConstants.RECORD_STATUS_DELETE);
		tripDataService.updateTripData(tripdata);
		
		return "redirect:openstate";
		
	}
	
	@RequestMapping(value = "/admin/trip/delete/form", method = RequestMethod.GET)
	public ModelAndView deleteTripForm(
			@ModelAttribute("tripCheckOutData") TripData tripdata,WebRequest request) {
		
		ModelAndView model = new ModelAndView();
		tripdata = tripDataService.getTripData(Long.parseLong(request.getParameter("tripId")));
		tripdata.setBus(busService.getBus(request.getParameter("busRegId")));
		tripdata.setEmployee(empService.getEmployeeById(Integer.parseInt(request.getParameter("empId"))));
		model.addObject("openTripForDelete", tripdata);
		model.setViewName("tripDeleteForm");

		return model;
	}
	

}
