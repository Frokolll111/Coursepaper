package pro.sky.Coursepaper5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Coursepaper5.model.Employee;
import pro.sky.Coursepaper5.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee max(@RequestParam int departmentId) {
        return service.max(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee min (@RequestParam int departmentId) {
        return service.min(departmentId);
    }
    @GetMapping()
    public Collection<Employee> allByDept(@RequestParam int departmentId) {
        return service.allByDept(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return service.all();
    }
}
