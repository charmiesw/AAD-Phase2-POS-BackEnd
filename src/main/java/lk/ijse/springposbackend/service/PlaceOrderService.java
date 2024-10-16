package lk.ijse.springposbackend.service;

import lk.ijse.springposbackend.dto.Order;
import lk.ijse.springposbackend.dto.OrderDetails;

import java.util.List;

public interface PlaceOrderService {
    void saveOrder(Order order);

    List<OrderDetails> getOrderDetails();
}
