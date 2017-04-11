package dao;

import model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SimpleCustomerDAO implements CustomerDAO {

    private List<Customer> customers;

    public SimpleCustomerDAO() {
        customers = new ArrayList();
        customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435", new Date(1994, 6, 12)));
        customers.add(new Customer(201, "John", "Smith", "sruss@gmail.com", "343-545-2345", new Date(1995, 2, 5)));
        customers.add(new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987", new Date(1993, 6, 25)));
    }

    /*
        Return the list of all the customers
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    /*
        Return a single customer on the basis of single id
     */
    @Override
    public Customer getCustomer(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    /*
        Deletes a customer based on his ID
     */
    @Override
    public boolean deleteCustomer(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }

    /*
        Update an existing customer
     */
    @Override
    public void updateCustomer(long id, Customer newCustomer) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                if (newCustomer.getFirstName() != null)
                    customer.setFirstName(newCustomer.getFirstName());
                if (newCustomer.getLastName() != null)
                    customer.setLastName(newCustomer.getLastName());
                if (newCustomer.getEmail() != null)
                    customer.setEmail(newCustomer.getEmail());
                if (newCustomer.getMobile() != null)
                    customer.setMobile(newCustomer.getMobile());
                if (newCustomer.getDateOfBirth() != null)
                    customer.setDateOfBirth(newCustomer.getDateOfBirth());
            }
        }
    }

    /*
        Create a new customer
     */
    @Override
    public void createCustomer(Customer customer) {
        customer.setId(System.currentTimeMillis());
        customers.add(customer);
    }
}
