package com.example.jpa.service;

import com.example.jpa.entity.Employee;
import com.example.jpa.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    static EmployeeMapper employeeMapper;

    public List<Employee> getEmployees() {

        List<Employee> employees = employeeMapper.findAll();
        return employees;
    }

}
