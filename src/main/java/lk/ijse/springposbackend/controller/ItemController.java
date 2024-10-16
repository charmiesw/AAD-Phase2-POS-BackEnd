package lk.ijse.springposbackend.controller;

import lk.ijse.springposbackend.customObj.ItemResponse;
import lk.ijse.springposbackend.dto.Item;
import lk.ijse.springposbackend.exception.DataPersistFailedException;
import lk.ijse.springposbackend.exception.ItemNotFoundException;
import lk.ijse.springposbackend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addItem(@RequestBody Item item) {
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } else {
            try {
                itemService.saveItem(item);
                logger.info("Item Saved Successfully : {}", item);
                return new ResponseEntity<>(HttpStatus.CREATED);

            } catch (DataPersistFailedException e) {
                logger.error("Failed To Persist Item Data : {}", item, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            } catch (Exception e) {
                logger.error("Unexpected Error Occurred While Saving Item : {}", item, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getItemByCode(@PathVariable("code") String code) {
        return itemService.getItemByCode(code);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{code}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable("code") String code, @RequestBody Item item) {
        try {
            if (item == null && (code == null || item.equals(""))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(code, item);
            logger.info("Item Updated Successfully : {}", item);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (ItemNotFoundException e) {
            logger.error("Item Not Found : ID {}", code, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            logger.error("Unexpected Error Occurred While Updating Item : {}", item, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteItem(@PathVariable("code") String code) {
        try {
            itemService.deleteItem(code);
            logger.info("Item Deleted Successfully : ID {}", code);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (ItemNotFoundException e) {
            logger.error("Item Not Found For Deletion : ID {}", code, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            logger.error("Unexpected Error Occurred While Deleting Item : ID {}", code, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
