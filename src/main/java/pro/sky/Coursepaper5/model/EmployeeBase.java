package pro.sky.Coursepaper5.model;

import org.springframework.stereotype.Repository;
import pro.sky.Coursepaper5.exception.EmployeeAlreadyAddedException;
import pro.sky.Coursepaper5.exception.EmployeeNotFoundException;

import java.util.*;

@Repository
public class EmployeeBase {

    private final List<Employee> storage = new ArrayList<>();

    private Map<Integer, Integer> esp = new HashMap<>();

    public Collection<Employee> findAll() {
        if (storage == null) {
            throw new NoSuchElementException();
        }
        return storage;
    }

    public Employee add(Employee employee) throws EmployeeAlreadyAddedException {
        if (storage.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        storage.add(employee);
        return employee;
    }

    public Employee remove(Employee employee) throws EmployeeNotFoundException {
        if (storage.contains(employee)) {
            storage.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(Employee employeeFind) throws EmployeeNotFoundException {
        if (storage.contains(employeeFind)) {
            return employeeFind;
        }
        throw new EmployeeNotFoundException();
    }
}