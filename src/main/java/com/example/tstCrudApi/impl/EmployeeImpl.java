package com.example.tstCrudApi.impl;

import com.example.tstCrudApi.entity.EmpList;
import com.example.tstCrudApi.entity.Employee;
import com.example.tstCrudApi.mapper.EmployeeMapper;
import com.example.tstCrudApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees(EmpList empList) {
        employeeMapper.getAllEmployees(empList);
        return empList.getEmployeeList();
    }

    @Override
    public Employee getEmployeeById(Map<String, Object> objectMap) {
        employeeMapper.getEmpById(objectMap);

        List<Employee> results=(List<Employee>) objectMap.get("result");
        Employee employee=results!=null&&!results.isEmpty()?results.get(0):new Employee();
        return employee;
    }

    @Override
    public void insertEmployee(String nik ,Employee employee) {
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("data",employee);
        objectMap.put("nik",nik);
        employeeMapper.addEmployee(objectMap);
    }

    public void deleteEmployee(String nik){
        employeeMapper.deleteByNik(nik);
    }
}
