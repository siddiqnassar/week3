package com.sapient.springdemo.model;

import lombok.Data;

@Data
public class Employee {
    private long id;
    private String name;
    private  int age;
    private double salary;

    public Employee(long id,String name,int age,double salary) {
    	this.id=id;
        this.age = age;
        this.name = name;
        this.salary=salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}