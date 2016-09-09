package com.brainyway.mrs.tpms.bus;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.brainyway.mrs.tpms.model.Bus;


@Controller
public class BusController {

	@Autowired
	BusService busService;
	
	private static final Logger logger = LoggerFactory.getLogger(BusController.class);

   @InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(  Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	
	}
	
	@RequestMapping(value = "/admin/bus/create", method = RequestMethod.POST)
	public ModelAndView createBus(@ModelAttribute("bus")Bus bus, WebRequest request) {

		logger.debug("Bus Data: " , bus);
		busService.createBus(bus);
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("statusMessageKey","Bus Data Has been Created successfully");
		modelView.setViewName("successPage");
		request.removeAttribute("bus",0);
		return modelView;

	}
	
	@RequestMapping(value = "/admin/bus/form", method = RequestMethod.GET)
	public ModelAndView createBusForm(@ModelAttribute("bus")Bus bus) {

		ModelAndView model = new ModelAndView();
		model.setViewName("newBusForm");
		return model;

	}
	
	}
