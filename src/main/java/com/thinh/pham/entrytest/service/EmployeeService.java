package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee employee);

    public void deleteById(int theId);

    boolean existsById(Integer theId);
}
