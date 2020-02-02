package com.example.jpa.mapper;

import com.example.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends JpaRepository<Employee,Integer > {
}
