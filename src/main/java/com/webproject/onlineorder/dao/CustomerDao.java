package com.webproject.onlineorder.dao;


import com.webproject.onlineorder.entity.Authorities;
import com.webproject.onlineorder.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//Repository和component是一个功能，更detail一点。
@Repository
public class CustomerDao {

    //
    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        Session session = null;
        // 给权限
        Authorities authorities = new Authorities();
        authorities.setEmail(customer.getEmail());
        authorities.setAuthorities("ROLE_USER");

        try {
            session = sessionFactory.openSession();
            // transaction 确保集体成功，集体失败
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }


    public Customer getCustomer(String email) {
        Customer customer = null;
        // try with resource, 会自动关闭resource在create之后
        try (Session session = sessionFactory.openSession()) {
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }

}



