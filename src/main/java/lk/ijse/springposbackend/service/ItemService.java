package lk.ijse.springposbackend.service;

import lk.ijse.springposbackend.customObj.ItemResponse;
import lk.ijse.springposbackend.dto.Item;

import java.util.List;

public interface ItemService {

    void saveItem(Item item);

    List<Item> getAllItems();

    ItemResponse getItemByCode(String code);

    void updateItem(String code, Item item);

    void deleteItem(String code);
}
