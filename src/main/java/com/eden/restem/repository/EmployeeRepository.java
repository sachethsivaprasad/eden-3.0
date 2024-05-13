package com.eden.restem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eden.restem.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}