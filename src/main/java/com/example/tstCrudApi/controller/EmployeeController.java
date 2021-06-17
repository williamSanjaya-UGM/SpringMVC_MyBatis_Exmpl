package com.example.tstCrudApi.controller;

import com.example.tstCrudApi.entity.EmpList;
import com.example.tstCrudApi.entity.Employee;
import com.example.tstCrudApi.impl.EmployeeImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeImpl empImpl;

    @RequestMapping(value = "/",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employee> getEmployees(@RequestBody EmpList empList) {
        return empImpl.getEmployees(empList);
    }

    @RequestMapping
    @ResponseBody
    public Employee getEmployeeById(@RequestParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Employee employee=new Employee();
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("id",id);
        objectMap.put("result",mapper.writeValueAsString(employee));
        return empImpl.getEmployeeById(objectMap);
    }

    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addEmployee(@RequestParam("nik") String nik,@RequestBody Employee employee){
        String inputNik=null;
        if(nik!=null||nik!=""){
            inputNik=nik;
        }
        empImpl.insertEmployee(inputNik,employee);
    }

    @RequestMapping(value = "/deleteEmployee",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteEmployee(@RequestParam("nik") String nik){
        empImpl.deleteEmployee(nik);
    }
}
