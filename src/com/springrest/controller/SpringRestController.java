package com.springrest.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springrest.services.*;
import com.springrest.beans.EmployeeDimensions;
import com.springrest.webclients.*;
@Controller
public class SpringRestController {
	SpringRestServices srs=new SpringRestServices();
	@RequestMapping(value="/Form",method = RequestMethod.GET )
	public ModelAndView welcomeHome() {
		// Name of your jsp file as parameter
		 ModelAndView mav = new ModelAndView("Form");
		 //System.out.println("fdsfdfdsfdsfsddf");
		 mav.addObject(new EmployeeDimensions());
		return mav;
	}
	
	/*@RequestMapping(value="/addEmployee",method = RequestMethod.POST)
	public ModelAndView welcomeFormData( @ModelAttribute("employeeDimensions") EmployeeDimensions employee) {
		// Name of your jsp file as parameter
		System.out.println("4er5e34e");
		ModelAndView view = new ModelAndView("Detail");
		view.addObject("name", employee.getName());
		view.addObject("id", employee.getId());

		return view;
	}*/
	@RequestMapping(value="/addEmployee",method = RequestMethod.POST)
	public ModelAndView welcomeFormData( @ModelAttribute("employeeDimensions") EmployeeDimensions employee) {
		ModelAndView view = new ModelAndView("Detail");
		view.addObject("name", employee.getName());
		view.addObject("id", employee.getId());
		Resttocalljson rs =new Resttocalljson();
		//response from webservice
		String response =rs.callwebservice(employee.getName());
		
		view.addObject("response", response);
		
		boolean status =srs.updateDbwithresponse(response);
		if(status){
			view.addObject("status","true");
			}
			else
			view.addObject("status","false");
		
		return view;
	}
}
