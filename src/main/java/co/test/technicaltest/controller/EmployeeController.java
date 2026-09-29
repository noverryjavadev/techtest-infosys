package co.test.technicaltest.controller;

import co.test.technicaltest.dto.EmployeeDto;
import co.test.technicaltest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/top-salaries")
    public List<EmployeeDto> getTop3HighestPaidEmployees() {
        return employeeService.getTop3HighestPaidEmployees();
    }
}
