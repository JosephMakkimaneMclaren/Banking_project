package com.bankingexample.banking_demo.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import com.bankingexample.banking_demo.exceptionHandler.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private HashMap<Long, Customer> customers = new HashMap<>();
    private AtomicLong idGenerator = new AtomicLong(1);

    public Customer addCustomer(String name, double initialBalance, String password) {
        long id = idGenerator.getAndIncrement();
        Customer customer = new Customer(name, initialBalance, password);
        //customer.setId(id);
        // customer.setName(name);
        // customer.setBalance(initialBalance);
        customers.put(id, customer);
        return customers.get(id);
    }
    public boolean loginCustomer(Long id, String password){
        Customer c = customers.get(id);
        boolean a = Objects.equals(password, c.getPassword());
        if(!a){
            throw new ResourceNotFoundException("Incorrect Password");
        }
        return a;
    }
    public Customer deposit(Long id, double amount) {
        Customer c = customers.get(id);
        double previous = c.getBalance();
        c.setBalance(previous + amount);
        c.setReceivedFrom("Bank");
        c.setReceivedDate(LocalDateTime.now());
        return c;
    }

    public Customer withdraw(Long id, double amount) {
        Customer c = customers.get(id);
        double previous = c.getBalance();
        c.setBalance(previous - amount);
        return c;
    }

    public Map<String, Customer> transfer(Long fromId, Long toId, double amount) {
        Customer sender = withdraw(fromId, amount);
        Customer receiver = deposit(toId, amount);
        sender.setTransferredTo(receiver.getName());
        sender.setTransferredDate(LocalDateTime.now());
        receiver.setReceivedFrom(sender.getName());
        receiver.setReceivedDate(LocalDateTime.now());
        return Map.of("from", sender, "to", receiver);
    }

    public Customer getCustomer(Long id) {
        return customers.get(id);
    }
    public Map<Long, Customer> getAllCustomers() {
        return customers;
    }
    public void deleteCustomer(Long id) {
        customers.remove(id);
    }
    public void updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = customers.get(id);
        if (existingCustomer != null) {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setBalance(updatedCustomer.getBalance());
            existingCustomer.setReceivedFrom(updatedCustomer.getReceivedFrom());
            existingCustomer.setReceivedDate(updatedCustomer.getReceivedDate());
            existingCustomer.setTransferredTo(updatedCustomer.getTransferredTo());
            existingCustomer.setTransferredDate(updatedCustomer.getTransferredDate());
        }
    }
    
}

