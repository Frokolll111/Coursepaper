package pro.sky.Coursepaper5.service;

import pro.sky.Coursepaper5.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName,int salary,int department);

    Employee remove(String firstName, String lastName,int salary,int department);


    Employee find(String firstName, String lastName,int salary,int department);


    Collection<Employee> findAll();

}
