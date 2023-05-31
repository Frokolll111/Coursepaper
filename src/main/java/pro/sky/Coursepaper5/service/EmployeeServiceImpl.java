package pro.sky.Coursepaper5.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.sky.Coursepaper5.exception.EmployeeAlreadyAddedException;
import pro.sky.Coursepaper5.exception.EmployeeNotFoundException;
import pro.sky.Coursepaper5.exception.InvalidInputException;
import pro.sky.Coursepaper5.model.Employee;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.*;

import static org.springframework.util.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {

        validateInput(firstName,lastName);

        Employee employee = new Employee(firstName, lastName,salary,department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int department) {
        validateInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName,salary,department);
        if (employees.containsKey(employee.getFullName())) {
            return  employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int department) {

        validateInput(firstName,lastName);


        Employee employee = new Employee(firstName, lastName,salary,department);

        if (employees.containsKey(employee.getFullName()    )) {
            return employees.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


    private void validateInput(String firstName, String lastName) {
        if (!(isEmpty(firstName) && isEmpty(lastName))) {
            throw new InvalidInputException();
        }
    }
}
