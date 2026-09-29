package co.test.technicaltest.repository;

import co.test.technicaltest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employees ORDER BY salary DESC LIMIT 3", nativeQuery = true)
    List<Employee> findTop3BySalary();
}
