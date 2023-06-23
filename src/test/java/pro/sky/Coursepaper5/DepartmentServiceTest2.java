package pro.sky.Coursepaper5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursepaper5.model.Employee;
import pro.sky.Coursepaper5.service.DepartmentService;
import pro.sky.Coursepaper5.service.EmployeeService;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest2 {

    @Mock
    EmployeeService service;
    @InjectMocks
    DepartmentService departmentService;

    private final Collection<Employee> employeeCollection = Set.of(
            new Employee("Максим", "Скрипников", 1000, 1),
            new Employee("Наташа", "Макарова", 2000, 2),
            new Employee("Никита", "Зверев", 13000, 1),
            new Employee("Света", "Липин", 4000, 2),
            new Employee("Андрей", "Кирпичников", 3000, 5));

    @Test
    public void TestMaxAndMinSalary() {
        when(service.findAll()).thenReturn(employeeCollection);

        Assertions.assertEquals(departmentService.max(1),departmentService.max(1));
        Assertions.assertEquals(departmentService.min(2),departmentService.min(2));

    }

    @Test
    public void getAllTest() {
        List<Employee> expected = Arrays.asList(
                new Employee("Максим", "Скрипников", 1000, 1),
                new Employee("Наташа", "Макарова", 2000, 2),
                new Employee("Никита", "Зверев", 13000, 1),
                new Employee("Света", "Липин", 4000, 2),
                new Employee("Андрей", "Кирпичников", 3000, 5));
          assertEquals(expected,employeeCollection);
    }
}
