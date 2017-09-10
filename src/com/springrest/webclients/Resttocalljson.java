package com.springrest.webclients;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.springrest.beans.EmployeeDimensions;

public class Resttocalljson {

	// http://localhost:8080/RESTfulExample/json/product/get
	public String callwebservice(String name) {
		StringBuffer buffer =new StringBuffer();
	  try {

		URL url = new URL("http://localhost:8090/RestFulWebSer/rest/myService/getemp/"+name);
		//System.out.println("url hit is "+"http://localhost:8090/RestFulWebSer/rest/myService/getemp/"+name);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			buffer.append(output);
			System.out.println(output);
		}
		Gson gson = new Gson();
		String jsonInString = buffer.toString();
		System.out.println(jsonInString);
		EmployeeDimensions e= gson.fromJson(jsonInString, EmployeeDimensions.class);
		
		System.out.println("employee data ::::::::::");
		System.out.println(e.getId()+e.getName()+e.getDepartment());
		
		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
	return buffer.toString();

	}

}