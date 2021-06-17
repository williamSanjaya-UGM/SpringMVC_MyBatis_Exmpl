package com.example.tstCrudApi.service;

import com.example.tstCrudApi.entity.EmpList;
import com.example.tstCrudApi.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {
    List<Employee> getEmployees(EmpList empList);
    Employee getEmployeeById(Map<String,Object> objectMap);
    void insertEmployee(String nik ,Employee employee);
    void deleteEmployee(String nik);
}
