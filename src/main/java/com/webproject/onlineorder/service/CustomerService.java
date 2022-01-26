package com.webproject.onlineorder.service;


import com.webproject.onlineorder.dao.CustomerDao;
import com.webproject.onlineorder.entity.Cart;
import com.webproject.onlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        // enabled and cart 不是前端能发送的值，所以要自己设置一下。
        // 设置true相当于激活
        customer.setEnabled(true);

        Cart cart = new Cart();
        customer.setCart(cart);


        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
