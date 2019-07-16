package com.sapient.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeCURDClient {

	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml ");
		EmployeeService employeeservice=context.getBean("employeeservice",EmployeeService.class);
		
	}
}
