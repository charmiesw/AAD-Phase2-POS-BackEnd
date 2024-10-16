package lk.ijse.springposbackend.controller;

import lk.ijse.springposbackend.customObj.CustomerResponse;
import lk.ijse.springposbackend.dto.Customer;
import lk.ijse.springposbackend.exception.CustomerNotFoundException;
import lk.ijse.springposbackend.exception.DataPersistFailedException;
import lk.ijse.springposbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    // Adding a Logger
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            logger.warn("Received Null Customer DTO..!!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } else {
            try {
                customerService.saveCustomer(customer);
                logger.info("Customer Saved Successfully : {}", customer);
                return new ResponseEntity<>(HttpStatus.CREATED);

            } catch (DataPersistFailedException e) {
                logger.error("Failed To Persist Customer Data : {}", customer, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            } catch (Exception e) {
                logger.error("Unexpected Error Occurred While Saving Customer : {}", customer, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers() {
        logger.info("Fetching All Customers..!!");
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getCustomerById(@RequestParam("id") String id) {
        logger.info("Fetching Customer With ID : {}", id);
        return customerService.getSelectedCustomer(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        try {
            if (customer == null && (id == null || customer.equals(""))){
                logger.warn("Invalid Customer Data Provided For Update : {}", customer);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            customerService.updateCustomer(id, customer);
            logger.info("Customer Updated Successfully : {}", customer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (CustomerNotFoundException e) {
            logger.error("Customer Not Found : ID {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            logger.error("Unexpected Error Occurred While Updating Customer : {}", customer, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id) {
        try {
            customerService.deleteCustomer(id);
            logger.info("Customer Deleted Successfully : ID {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (CustomerNotFoundException e) {
            logger.error("Customer Not Found For Deletion : ID {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            logger.error("Unexpected Error Occurred While Deleting Customer : ID {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
