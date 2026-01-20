package com.mednet.employee.service;

import com.mednet.employee.dao.EmployeeDao;
import com.mednet.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    // Register Employee
    public void registerEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    //  Login Check
    public Employee login(String loginId, String password) {
        return employeeDao.login(loginId, password);
    }

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
