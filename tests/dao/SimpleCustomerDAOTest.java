package dao;


import model.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleCustomerDAOTest {

    private CustomerDAO customerDAO;

    @Before
    public void setUp() throws Exception {
        customerDAO = new SimpleCustomerDAO();
    }

    @Test
    public void shouldAbleToGetAllCustomers() throws Exception {
        List<Customer> customers = customerDAO.getAllCustomers();
        assertEquals(3,customers.size());

    }

    @Test
    public void shouldBeAbleToAddNewCustomer() throws Exception {
        Customer customer = new Customer(100, "firstname", "lastname", "email", "mobile", new Date());
        customerDAO.createCustomer(customer);

        assertEquals(4,customerDAO.getAllCustomers().size()); // 3 customers are already added in the constructor

    }

    @Test
    public void shouldAbleToGetSingleCustomer() throws Exception {
        Customer customer = customerDAO.getCustomer(101);
        assertTrue(customer.getFirstName().equalsIgnoreCase("John"));

    }

    @Test
    public void shouldAbleToDeleteCustomer() throws Exception {
        boolean isCustomerDeleted = customerDAO.deleteCustomer(101);

        assertEquals(2,customerDAO.getAllCustomers().size());
        assertTrue(isCustomerDeleted);

    }

    @Test
    public void shouldAbleToUpdateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Alan");

        customerDAO.updateCustomer(101,customer);

        assertEquals("Alan",customerDAO.getCustomer(101).getFirstName());

    }
}