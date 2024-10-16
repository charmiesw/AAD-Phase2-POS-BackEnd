package lk.ijse.springposbackend.dto;

import lk.ijse.springposbackend.customObj.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order implements Super, OrderResponse {
    private String oId;
    private String date;
    private double total;
    private String customerId;
    private List<OrderDetails> orderDetails;
}
