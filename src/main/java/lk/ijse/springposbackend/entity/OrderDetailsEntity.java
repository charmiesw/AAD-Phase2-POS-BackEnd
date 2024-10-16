package lk.ijse.springposbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderDetailsEntity implements SuperEntity {
    @Id
    private String itemCode;
    private String itemName;
    private String itemDescription;
    private int qty;
    private double unitPrice;
    private double total;
}
