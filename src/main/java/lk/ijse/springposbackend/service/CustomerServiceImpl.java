package lk.ijse.springposbackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.springposbackend.customObj.CustomerResponse;
import lk.ijse.springposbackend.dao.CustomerDAO;
import lk.ijse.springposbackend.dto.Customer;
import lk.ijse.springposbackend.entity.CustomerEntity;
import lk.ijse.springposbackend.exception.CustomerNotFoundException;
import lk.ijse.springposbackend.exception.DataPersistFailedException;
import lk.ijse.springposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(Customer customer) {
        CustomerEntity save = customerDAO.save(mapping.convertCustomerDTOToCustomerEntity(customer));
        if (save == null){
            throw new DataPersistFailedException("Cannot Save Customer..!!");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return mapping.convertCustomerEntityListToCustomerDTOList(customerDAO.findAll());
    }

    @Override
    public CustomerResponse getSelectedCustomer(String id) {
        if (customerDAO.existsById(id)) {
            return mapping.convertCustomerEntityToCustomerDTO(customerDAO.getReferenceById(id));
        }else {
            throw new CustomerNotFoundException("Customer Not Found..!!");
        }
    }

    @Override
    public void updateCustomer(String id, Customer customer) {
        Optional<CustomerEntity> tmp = customerDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer Not Found..!!");
        }else {
            tmp.get().setName(customer.getName());
            tmp.get().setAddress(customer.getAddress());
            tmp.get().setContact(customer.getContact());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<CustomerEntity> tmp = customerDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer Not Found..!!");
        }else {
            customerDAO.deleteById(id);
        }
    }
}
