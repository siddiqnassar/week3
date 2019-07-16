package com.sapient.SpringDemo;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public List<Employee> fetchAllEmployee();
	public Employee findById(long id);
	public void deleteEmployees(long id);
	
}
