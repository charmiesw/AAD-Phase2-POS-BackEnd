package lk.ijse.springposbackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.springposbackend.dao.OrderDAO;
import lk.ijse.springposbackend.dao.OrderDetailsDAO;
import lk.ijse.springposbackend.dto.Order;
import lk.ijse.springposbackend.dto.OrderDetails;
import lk.ijse.springposbackend.entity.OrderDetailsEntity;
import lk.ijse.springposbackend.entity.OrderEntity;
import lk.ijse.springposbackend.exception.DataPersistFailedException;
import lk.ijse.springposbackend.util.AppUtil;
import lk.ijse.springposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(Order order) {

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOId(AppUtil.createOrderId());
        orderEntity.setDate(order.getDate());
        orderEntity.setTotal(order.getTotal());
        orderEntity.setCustomerId(order.getCustomerId());

        OrderEntity save = orderDAO.save(orderEntity);

        List<OrderDetails> orderDetails = order.getOrderDetails();

        for(OrderDetails orderDetailsDTO : orderDetails) {

            OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();

            orderDetailsEntity.setItemCode(orderDetailsDTO.getItemCode());
            orderDetailsEntity.setItemName(orderDetailsDTO.getItemName());
            orderDetailsEntity.setItemDescription(orderDetailsDTO.getItemDescription());
            orderDetailsEntity.setQty(orderDetailsDTO.getQty());
            orderDetailsEntity.setUnitPrice(orderDetailsDTO.getUnitPrice());
            orderDetailsEntity.setTotal(orderDetailsDTO.getTotal());

            orderDetailsDAO.save(orderDetailsEntity);
        }

        if(save == null){
            throw  new DataPersistFailedException("Failed To Save Order..!!");
        }
    }

    @Override
    public List<OrderDetails> getOrderDetails() {
        return mapping.convertOrderDetailEntityListToOrderDetailDTOList(orderDetailsDAO.findAll());
    }
}
