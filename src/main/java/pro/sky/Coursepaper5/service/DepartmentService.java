package pro.sky.Coursepaper5.service;

import org.springframework.stereotype.Service;
import pro.sky.Coursepaper5.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee max(int department) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    public Employee min(int department) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public Collection<Employee> allByDept(int department) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> all() {
        return employeeService.findAll()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }

}
