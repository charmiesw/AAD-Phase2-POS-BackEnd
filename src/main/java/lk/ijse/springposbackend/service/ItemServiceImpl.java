package lk.ijse.springposbackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.springposbackend.customObj.ItemResponse;
import lk.ijse.springposbackend.dao.ItemDAO;
import lk.ijse.springposbackend.dto.Item;
import lk.ijse.springposbackend.entity.ItemEntity;
import lk.ijse.springposbackend.exception.DataPersistFailedException;
import lk.ijse.springposbackend.exception.ItemNotFoundException;
import lk.ijse.springposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(Item item) {
        ItemEntity save = itemDAO.save(mapping.convertItemDTOToItemEntity(item));
        if (save == null){
            throw new DataPersistFailedException("Cannot Save Item..!!");
        }
    }

    @Override
    public List<Item> getAllItems() {
       return mapping.convertItemEntityListToItemDTOList(itemDAO.findAll());
    }

    @Override
    public ItemResponse getItemByCode(String code) {
        if (itemDAO.existsById(code)) {
            return mapping.convertItemEntityToItemDTO(itemDAO.getReferenceById(code));
        }else {
            throw new ItemNotFoundException("Item Not Found..!!");
        }
    }

    @Override
    public void updateItem(String code, Item item) {
        Optional<ItemEntity> tmp = itemDAO.findById(code);
        if (!tmp.isPresent()) {
            throw new ItemNotFoundException("Item Not Found..!!");
        }else {
            tmp.get().setName(item.getName());
            tmp.get().setDescription(item.getDescription());
            tmp.get().setUnit_price(item.getUnit_price());
        }
    }

    @Override
    public void deleteItem(String code) {
        Optional<ItemEntity> tmp = itemDAO.findById(code);
        if (!tmp.isPresent()) {
            throw new ItemNotFoundException("Item Not Found..!!");
        }else {
            itemDAO.deleteById(code);
        }
    }
}
