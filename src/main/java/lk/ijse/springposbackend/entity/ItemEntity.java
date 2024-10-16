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
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    private String code;
    private String name;
    private String description;
    private Double unit_price;
}
