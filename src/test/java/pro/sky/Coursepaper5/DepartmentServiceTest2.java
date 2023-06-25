package pro.sky.Coursepaper5;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursepaper5.model.Employee;
import pro.sky.Coursepaper5.service.DepartmentService;
import pro.sky.Coursepaper5.service.EmployeeService;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.xmlunit.util.Linqy.map;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest2 {

    @Mock
    EmployeeService service;
    @InjectMocks
    DepartmentService departmentService;

    private final List<Employee> employeeCollection = List.of(
            new Employee("Максим", "Скрипников", 1000, 2),
            new Employee("Наташа", "Макарова", 2000, 2),
            new Employee("Наташа", "Макарова", 2000, 3));

    @BeforeEach
    void setUp() {
        when(service.findAll()).thenReturn(employeeCollection);
    }

    @Test
    public void TestMaxAndMinSalary() {
        when(service.findAll()).thenReturn(employeeCollection);

        Assertions.assertEquals(departmentService.max(1),departmentService.max(1));
        Assertions.assertEquals(departmentService.min(2),departmentService.min(2));

    }

    @Test
    void ReturnGroupedByDepartmentEmployees() {
        List<Employee> actual = (List<Employee>) departmentService.allByDept(2);
        List<Employee> expected = Arrays.asList(
                new Employee("Максим", "Скрипников", 1000, 2),
                new Employee("Наташа", "Макарова", 1000, 2)
        );
        assertEquals(expected.size(),actual.size());
        assertFalse(expected.containsAll(actual));
    }

    @Test
    void getAll() {
        List<Integer>  departments = employeeCollection.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());

        Map<Integer, List<Employee>> all = departmentService.all();
         assertEquals(departments.size(),all.keySet().size());
         assertTrue(departments.containsAll(all.keySet()));
    }
}
