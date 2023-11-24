package com.mycompany.cepa3hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAO {

    private Session session;

    public EmployeeDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List<Employee> getEmployees(int page, int pageSize) {
        try {
            session.getTransaction().begin();

            Query<Employee> query = (Query<Employee>) session.getNamedQuery("from Employee");
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);

            List<Employee> employees = query.list();

            session.getTransaction().commit();

            return employees;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Error getting employees: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }
}
