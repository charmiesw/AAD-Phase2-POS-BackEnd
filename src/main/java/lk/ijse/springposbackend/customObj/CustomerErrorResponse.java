package lk.ijse.springposbackend.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse implements Serializable, CustomerResponse {
    private int errorCode;
    private String errorMessage;
}
