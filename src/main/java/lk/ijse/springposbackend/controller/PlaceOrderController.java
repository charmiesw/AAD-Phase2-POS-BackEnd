package lk.ijse.springposbackend.controller;

import lk.ijse.springposbackend.dto.Order;
import lk.ijse.springposbackend.dto.OrderDetails;
import lk.ijse.springposbackend.exception.DataPersistFailedException;
import lk.ijse.springposbackend.service.PlaceOrderService;
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
@RequestMapping("api/v1/placeOrder")
@RequiredArgsConstructor
public class PlaceOrderController {

    @Autowired
    private final PlaceOrderService placeOrderService;

    private static final Logger logger = LoggerFactory.getLogger(PlaceOrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody Order order) {
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } else {
            try {
                placeOrderService.saveOrder(order);
                logger.info("Order Placed Successfully : {}", order);
                return new ResponseEntity<>(HttpStatus.CREATED);

            } catch (DataPersistFailedException e) {
                logger.error("Failed To Persist Order Data : {}", order, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            } catch (Exception e) {
                logger.error("Unexpected Error Occurred While Saving Order : {}", order, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetails> getOrderDetails() {
        return placeOrderService.getOrderDetails();
    }
}
