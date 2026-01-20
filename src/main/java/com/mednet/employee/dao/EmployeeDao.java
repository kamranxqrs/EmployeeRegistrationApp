package com.mednet.employee.dao;

import com.mednet.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    // Saving the employee
    public void saveEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(employee);

        tx.commit();
        session.close();
    }

    // Login check
    public Employee login(String loginId, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee emp = session.createQuery(
                "FROM Employee WHERE loginId = :loginId AND password = :password",
                Employee.class)
                .setParameter("loginId", loginId)
                .setParameter("password", password)
                .uniqueResult();

        session.close();
        return emp;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employee> list = session
                .createQuery("FROM Employee", Employee.class)
                .list();

        session.close();
        return list;
    }
}
