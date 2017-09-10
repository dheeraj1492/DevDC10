package com.springrest.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.springrest.beans.EmployeeDimensions;



public class SpringRestUpdates {
	public boolean updateempdata(EmployeeDimensions employee){
		boolean status =false;
 SessionFactory factory; 

	    try{
	  	  
	  	  Configuration configuration= new AnnotationConfiguration().configure();
	  	  configuration.getProperty("hibernate.dialect");
	  	  System.out.println("findshine"+configuration.getProperty("hibernate.dialect"));
	  	 factory= configuration.buildSessionFactory();
	  	  
	  	  
	  	  
	    }catch (Throwable ex) { 
	       System.err.println("Failed to create sessionFactory object." + ex);
	       throw new ExceptionInInitializerError(ex); 
	    }			
	 

	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try{
	         tx = session.beginTransaction();
	         /*EmployeeDimensions employee = new EmployeeDimensions();
	         employee.setId(id);
	         employee.setName(name);
	         employee.setJoblevel(joblevel);
	         employee.setDepartment(department);*/
	         session.saveOrUpdate(employee); 
	         tx.commit();
	         
	         status =true;
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	    return status;
		
	}
	
	
}
