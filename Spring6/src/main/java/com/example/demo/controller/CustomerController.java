package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController {
    private final CustomerDAO customerDAO;

    @GetMapping()
    List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @PostMapping()
    void createCustomer(@RequestBody Customer customer) {
        customerDAO.create(customer);
    }

    @GetMapping("/view")
    public ModelAndView allCustomersView() {
        List<Customer> customers = customerDAO.findAll();
        ModelAndView modelAndView = new ModelAndView("customersView");
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView oneCustomerView(@PathVariable Integer id) {
        List<Customer> customers = new ArrayList<>();
        Optional<Customer> customer = customerDAO.get(id);
        customer.ifPresent(customers::add);
        ModelAndView modelAndView = new ModelAndView("customersView");
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

    @GetMapping("/filter")
    public ModelAndView filterCustomers(@RequestParam(value = "username", required = false) String username,
                                        @RequestParam(value = "city", required = false) String city,
                                        @RequestParam(value = "country", required = false) String country) {
        List<Customer> customers = customerDAO.findAllByUsernameAndCityAndCountry(username, city, country);
        ModelAndView modelAndView = new ModelAndView("customersView");
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

}
