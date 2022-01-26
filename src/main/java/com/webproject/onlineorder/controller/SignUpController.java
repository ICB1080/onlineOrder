package com.webproject.onlineorder.controller;

import com.webproject.onlineorder.entity.Customer;
import com.webproject.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    // RequestBody: convert the request body in the http request
    // to a backend object: here is a customer object
    public void signup(@RequestBody Customer customer){
        customerService.signUp(customer);

    }
}
