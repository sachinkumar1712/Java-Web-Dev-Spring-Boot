package org.example;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args){
        EmployeeDao employeeDao = new EmployeeDao();
//        List<Employee>employees =  employeeDao.findAll();

          //print All Employee
//        for(Employee employee:employees){
//            System.out.println(employee);
//        }
        //Find by Id
//        System.out.println(employeeDao.findById(1));

        //insert new employee
//        Employee employee = new Employee("Mridul","SOT",956376);
//        employeeDao.save(employee);
//        for(Employee employee1:employees){
//            System.out.println(employee1);
//        }
//
         //Delete data
//        employeeDao.delete(102);
//        for(Employee e:employees){
//            System.out.println(e);
//        }


        //Update Employee
        Employee emp = employeeDao.findById(15);
        emp.setDept("Sales");
        emp.setSalary(500000.0);
        employeeDao.update(emp);
        List<Employee>employees =  employeeDao.findAll();
        for(Employee employee1:employees){
            System.out.println(employee1);
        }
    }
}
