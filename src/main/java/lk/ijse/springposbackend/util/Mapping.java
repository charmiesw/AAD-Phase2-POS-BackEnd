package lk.ijse.springposbackend.util;

import lk.ijse.springposbackend.dto.Customer;
import lk.ijse.springposbackend.dto.Item;
import lk.ijse.springposbackend.dto.Order;
import lk.ijse.springposbackend.dto.OrderDetails;
import lk.ijse.springposbackend.entity.CustomerEntity;
import lk.ijse.springposbackend.entity.ItemEntity;
import lk.ijse.springposbackend.entity.OrderDetailsEntity;
import lk.ijse.springposbackend.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public Customer convertCustomerEntityToCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, Customer.class);
    }

    public CustomerEntity convertCustomerDTOToCustomerEntity(Customer customer) {
        return modelMapper.map(customer, CustomerEntity.class);
    }

    public List<Customer> convertCustomerEntityListToCustomerDTOList(List<CustomerEntity> customerEntityList) {
        return modelMapper.map(customerEntityList, new TypeToken<List<Customer>>() {}.getType());
    }

    public Item convertItemEntityToItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, Item.class);
    }

    public ItemEntity convertItemDTOToItemEntity(Item item) {
        return modelMapper.map(item, ItemEntity.class);
    }

    public List<Item> convertItemEntityListToItemDTOList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList, new TypeToken<List<Item>>() {}.getType());
    }

    public Order convertOrderEntityToOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, Order.class);
    }

    public OrderEntity convertOrderDTOToOrderEntity(Order order) {
        return modelMapper.map(order, OrderEntity.class);
    }

    public OrderDetails convertOrderDetailsEntityToOrderDetailsDTO(OrderDetailsEntity orderDetailsEntity) {
        return modelMapper.map(orderDetailsEntity, OrderDetails.class);
    }

    public OrderDetailsEntity convertOrderDetailsDTOToOrderDetailsEntity(OrderDetails orderDetails) {
        return modelMapper.map(orderDetails, OrderDetailsEntity.class);
    }

    public List<OrderDetails> convertOrderDetailEntityListToOrderDetailDTOList(List<OrderDetailsEntity> orderDetailsEntityList) {
        return modelMapper.map(orderDetailsEntityList, new TypeToken<List<OrderDetails>>() {}.getType());
    }
}
