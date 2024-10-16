package lk.ijse.springposbackend.dao;

import lk.ijse.springposbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, String> {
}
