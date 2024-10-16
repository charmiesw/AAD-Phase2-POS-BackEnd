package lk.ijse.springposbackend.dto;

import lk.ijse.springposbackend.customObj.OrderDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails implements Super, OrderDetailsResponse {
    private String itemCode;
    private String itemName;
    private String itemDescription;
    private int qty;
    private double unitPrice;
    private double total;
}
