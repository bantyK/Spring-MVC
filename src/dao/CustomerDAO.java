package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomers();
    Customer getCustomer(long id);
    void createCustomer(Customer customer);
    boolean deleteCustomer(long id);
    void updateCustomer(long id, Customer customer);
}
