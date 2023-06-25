package pro.sky.Coursepaper5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursepaper5.model.Employee;
import pro.sky.Coursepaper5.model.EmployeeBase;
import pro.sky.Coursepaper5.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeBase storageMock;

    @InjectMocks
    private DepartmentService departmentService;
    Employee WORKER_FIRST = new Employee("Наташа", "Марякова", 1000, 1);
    Employee WORKER_SECOND = new Employee("Сергей", "Каштанов", 2000, 1);
    Employee WORKER_THIRD = new Employee("Люда", "Валикова", 2000, 2);

    @Test
    public void TestMaxAndMinSalary() {
        final List<Employee> employees = List.of(WORKER_FIRST, WORKER_SECOND);

        when(storageMock.findAll()).thenReturn(employees);
        assertEquals(WORKER_FIRST, departmentService.min(1));
        assertEquals(WORKER_SECOND,departmentService.max(1));

        assertThrows(NoSuchElementException.class, () -> departmentService.max(2));
        assertThrows(NoSuchElementException.class, () -> departmentService.min(2));

        assertThrows(IllegalArgumentException.class,() -> departmentService.max(3));
        assertThrows(IllegalArgumentException.class,() -> departmentService.min(3));
        assertThrows(IllegalArgumentException.class,() -> departmentService.max(0));
        assertThrows(IllegalArgumentException.class,() -> departmentService.min(0));
    }

    @Test
    public void getAllByDeptTest() {
        final List<Employee> employees1 = List.of(WORKER_FIRST, WORKER_SECOND,WORKER_THIRD);
        final List<Employee> employees2 = List.of(WORKER_FIRST, WORKER_SECOND);
        when(storageMock.findAll()).thenReturn(employees1);

        assertEquals(employees2.stream()
                .map(employee -> employee.toString())
                .collect(Collectors.joining()),
                departmentService.allByDept(1) );

        assertThrows(IllegalArgumentException.class, () -> departmentService.allByDept(3));
        assertThrows(IllegalArgumentException.class, () -> departmentService.allByDept(0));

        when(storageMock.findAll()).thenThrow(NoSuchElementException.class);
        assertEquals("Collection is Empty",departmentService.allByDept(3));
    }
}
