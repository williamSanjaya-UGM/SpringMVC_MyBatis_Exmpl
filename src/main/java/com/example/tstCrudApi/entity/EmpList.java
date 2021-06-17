package com.example.tstCrudApi.entity;

import java.io.Serializable;
import java.util.List;

public class EmpList implements Serializable {
    private int startFrom;
    private int until;
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(int startFrom) {
        this.startFrom = startFrom;
    }

    public int getUntil() {
        return until;
    }

    public void setUntil(int until) {
        this.until = until;
    }

    @Override
    public String toString() {
        return "EmpList{" +
                "startFrom=" + startFrom +
                ", until=" + until +
                ", employeeList=" + employeeList +
                '}';
    }
}
