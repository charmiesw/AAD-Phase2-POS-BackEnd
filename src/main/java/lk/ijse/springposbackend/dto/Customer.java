package lk.ijse.springposbackend.dto;

import lk.ijse.springposbackend.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Super, CustomerResponse {
    String id;
    String name;
    String address;
    String contact;
}
