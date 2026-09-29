package co.test.technicaltest.service;

import co.test.technicaltest.dto.EmployeeDto;
import co.test.technicaltest.entity.Employee;
import co.test.technicaltest.exception.NotFoundException;
import co.test.technicaltest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto getEmployeeById(Long id) {
        Employee employee =  employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .position(employee.getPosition())
                .build();
    }


    public List<EmployeeDto> getTop3HighestPaidEmployees() {
        List<Employee> employees = employeeRepository.findTop3BySalary();

        return employees.stream()
                .map(employee -> EmployeeDto.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .position(employee.getPosition())
                        .build())
                .collect(Collectors.toList());
    }
}
