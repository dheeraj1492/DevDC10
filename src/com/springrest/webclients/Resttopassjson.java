package com.springrest.webclients;

import com.google.gson.Gson;
import com.springrest.beans.EmployeeDimensions;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



public class Resttopassjson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
		  try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://localhost:8090/RestFulWebSer/rest/myService/getjson/");

				//String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
				EmployeeDimensions e =new EmployeeDimensions();
				  e.setId(100000);
				  e.setDepartment("marketing");
				  e.setJoblevel("tome");
				  e.setName("namasdfdsdfn");
				  Gson gson = new Gson();
				  String input=gson.toJson(e);
				ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, input);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}

				System.out.println("Output from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(output);

			  } catch (Exception e) {

				e.printStackTrace();

			  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
	}

}
