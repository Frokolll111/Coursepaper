package pro.sky.Coursepaper5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursepaper5.exception.EmployeeAlreadyAddedException;
import pro.sky.Coursepaper5.exception.EmployeeNotFoundException;
import pro.sky.Coursepaper5.model.Employee;
import pro.sky.Coursepaper5.model.EmployeeBase;
import pro.sky.Coursepaper5.service.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeBase storageMock;
    @InjectMocks
    private EmployeeServiceImpl out;

    @Test
    public void testForAddingDeletingAndSearchingMethods() throws EmployeeAlreadyAddedException, EmployeeNotFoundException {
        final Employee WORKER_FIRST = new Employee("Наташа", "Марякова", 1000, 1);

        when(storageMock.add(WORKER_FIRST)).thenReturn(WORKER_FIRST);
        when(storageMock.remove(WORKER_FIRST)).thenReturn(WORKER_FIRST);
        when(storageMock.find(WORKER_FIRST)).thenReturn(WORKER_FIRST);

        assertEquals(WORKER_FIRST, out.add("Наташа", "Марякова", 1000, 1));
        assertEquals(WORKER_FIRST, out.remove("Наташа", "Марякова", 1000, 1));
        assertEquals(WORKER_FIRST, out.find("Наташа", "Марякова", 1000, 1));

        verify(storageMock, times(1)).add(WORKER_FIRST);
        verify(storageMock, times(1)).remove(WORKER_FIRST);
        verify(storageMock, times(1)).find(WORKER_FIRST);

    }
}
