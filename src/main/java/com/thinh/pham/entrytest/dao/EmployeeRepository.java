package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
