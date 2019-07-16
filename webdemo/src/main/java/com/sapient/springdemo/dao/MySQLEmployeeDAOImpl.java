package com.sapient.springdemo.dao;

import com.sapient.springdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository(value = "mysqlDAOImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public MySQLEmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee save(Employee employee) {
        System.out.println("Came inside the save method of MySQLEmployeeDAOImpl");
        jdbcTemplate.execute("insert into employee(id,name1,salary,age) values ('"+employee.getId()+"','"+employee.getName()+"','"+employee.getSalary()+"','"+employee.getAge()+"')");
      
        return employee;
    }

    public List<Employee> listAll() {
    	List<Employee> employeeList = jdbcTemplate.query("select * from employee",
                ( rs, rowNum)-> new Employee(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4)));
    	 for(Employee employee:employeeList)
         {
         	System.out.println(employee.getName());
         }
        return employeeList;
        
    }

    public Employee findById(long id) {
    	List<Employee> employeeList = jdbcTemplate.query("select * from employee where id="+id,
                ( rs, rowNum)-> new Employee(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4)));
    	 for(Employee employee:employeeList)
         {
    		 if(employee.getId()==id)
    		 {
    			 Employee e=employee;
    			 e.setAge(45);
    			 return e;
    		 }
         	System.out.println(employee.getName());
         }
      
//    	List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from employee");
//        Employee e;
//            for(Map<String, Object> row : rows){
//               int id1 = (int) row.get("id");
//               if(id==id1) {
//               String name = (String)row.get("name1");
//               int age = (int) row.get("age");
//               int sal = (int) row.get("salary");
//               System.out.println(id + " " + name  );
//               e=new Employee(id1,name,age,sal);
//              
//               return e;
//               }
//             }
       
            return null;
        
    }

    public void deleteEmployee(long id) {

    }
}