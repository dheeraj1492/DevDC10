package com.springrest.services;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.springrest.beans.EmployeeDimensions;
import com.springrest.dao.SpringRestUpdates;


public class SpringRestServices {

	SpringRestUpdates spreupd=new SpringRestUpdates();
public boolean updateDbwithresponse(String resp){
	
	Gson g = new Gson(); 
	EmployeeDimensions e= g.fromJson(resp, EmployeeDimensions.class);
	boolean status=spreupd.updateempdata(e);
	return status;
}	
}
