package lk.ijse.springposbackend.dto;

import lk.ijse.springposbackend.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements Super, ItemResponse {
    private String code;
    private String name;
    private String description;
    private Double unit_price;
}
