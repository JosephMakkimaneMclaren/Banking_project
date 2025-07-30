package com.bankingexample.banking_demo.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("login/{id}")
    public ResponseEntity<Boolean> loginCustomer(@PathVariable Long id, @RequestBody String password) {
        return ResponseEntity.ok(service.loginCustomer(id,password));
    }

    @PostMapping ("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customerDetails) {
        String name = customerDetails.getName();
        double balance = customerDetails.getBalance();
        String password = customerDetails.getPassword();

        
        return ResponseEntity.ok(service.addCustomer(name, balance, password));
    }

    @PatchMapping("/{id}/deposit")
    public double deposit(@PathVariable Long id, @RequestBody double amount) {
        return service.deposit(id, amount).getBalance();
    }

    @PatchMapping("/{id}/withdraw")
    public double withdraw(@PathVariable Long id, @RequestBody double amount) {
        return service.withdraw(id, amount).getBalance();
    }

    @PostMapping("/{fromId}/transfer/{toId}")
    public ResponseEntity<Map<String, Customer>> transfer(
        @PathVariable Long fromId,
        @PathVariable Long toId,
        @RequestBody double amount
    ) {
        return ResponseEntity.ok(service.transfer(fromId, toId, amount));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomer(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Map<Long, Customer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());    
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) { 
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


}
