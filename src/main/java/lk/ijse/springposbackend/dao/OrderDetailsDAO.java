package lk.ijse.springposbackend.dao;

import lk.ijse.springposbackend.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetailsEntity, String> {
}
