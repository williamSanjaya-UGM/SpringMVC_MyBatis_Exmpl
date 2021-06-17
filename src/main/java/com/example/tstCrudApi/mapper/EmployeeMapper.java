package com.example.tstCrudApi.mapper;

import com.example.tstCrudApi.entity.EmpList;
import com.example.tstCrudApi.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<Employee> getAllEmployees(EmpList empList);
    Employee getEmpById(Map<String,Object> objectMap);
    void addEmployee (Map<String,Object> objectMap);
    void deleteByNik(String nik);
}
