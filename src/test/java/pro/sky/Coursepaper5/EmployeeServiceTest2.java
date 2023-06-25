package pro.sky.Coursepaper5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Coursepaper5.exception.EmployeeNotFoundException;
import pro.sky.Coursepaper5.model.Employee;
import pro.sky.Coursepaper5.service.EmployeeServiceImpl;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest2 {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @BeforeEach
    public void List() {
        employeeService.add("Максим", "Скрипников", 1000, 1);
        employeeService.add("Наташа", "Макарова", 2000, 3);
    }
    @Test
    void testAdd() {
        Employee expected = new Employee("Никита", "Зверев", 3000, 4);
        Assertions.assertEquals(expected,employeeService.add("Никита", "Зверев", 3000, 4));
    }

    @Test
    public void removeTest() {
        Employee expected = new Employee("Наташа", "Макарова", 2000, 3);
        Employee actual = employeeService.remove("Наташа", "Макарова", 2000, 3);
    }

    @Test
    public void removeExceptionTest() {
        assertThrows(EmployeeNotFoundException.class,()->{
            employeeService.remove("Света", "Липин", 1000, 1);
        });
    }

    @Test
    public void getAllTest() {
        List<Employee> expected = Arrays.asList(
                new Employee("Максим", "Скрипников", 1000, 1),
                new Employee("Наташа", "Макарова", 2000, 3));
        assertEquals(2,employeeService.findAll().size());
        assertIterableEquals(expected,employeeService.findAll());
    }
}
