package lk.ijse.springposbackend.service;

import lk.ijse.springposbackend.customObj.CustomerResponse;
import lk.ijse.springposbackend.dto.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    CustomerResponse getSelectedCustomer(String id);

    void updateCustomer(String id, Customer customer);

    void deleteCustomer(String id);
}
