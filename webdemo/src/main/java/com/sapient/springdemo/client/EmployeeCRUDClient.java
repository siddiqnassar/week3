package com.sapient.springdemo.client;

import com.sapient.springdemo.model.Employee;
import com.sapient.springdemo.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeCRUDClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        //Java configuration
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = context.getBean("employeeService" ,EmployeeService.class);
        Employee pavan = new Employee(10001, "Pavan",23,50000);
        employeeService.saveEmployee(pavan);
        List<Employee> employeelist=employeeService.fetchAllEmployees();
        for(Employee employee:employeelist)
        {
        	System.out.println(employee);
        }
        System.out.println("enter ay id to find");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        Employee emp=employeeService.findById(id);
        if(emp!=null)
        {
        System.out.println(emp);
        }
        else
        {
        	System.out.println("id not found");
        }
    }
}