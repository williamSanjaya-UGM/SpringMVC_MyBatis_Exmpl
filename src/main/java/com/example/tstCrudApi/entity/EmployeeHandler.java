package com.example.tstCrudApi.entity;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.List;

public class EmployeeHandler implements TypeHandler<Employee> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Employee employee, JdbcType jdbcType) throws SQLException {
        StructDescriptor structDescriptor=StructDescriptor.createDescriptor("EMP_HR_OBJ",ps.getConnection());

        Struct[] structs=new Struct[1];

        Object[] params=new Object[6];
        params[0]=employee.getNik();
        params[1]=employee.getName();
        params[2]=employee.getPhoneNumber();
        params[3]=employee.getAddress();
        params[4]=employee.getPosition();
        params[5]=employee.getSalary();
        STRUCT struct=new STRUCT(structDescriptor, ps.getConnection(), params);
        structs[0]=struct;

        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("EMP_HR_TEMP", ps.getConnection());
        ARRAY oracleArray = new ARRAY(desc, ps.getConnection(), structs);
        ps.setArray(i, oracleArray);
    }

    @Override
    public Employee getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Employee getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Employee getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
