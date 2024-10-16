package lk.ijse.springposbackend.dao;

import lk.ijse.springposbackend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity, String> {
}
