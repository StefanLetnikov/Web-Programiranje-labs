package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    public Order placeOrder(String balloonColor, String balloonSize, String clientName, String address)
    {
        Order order=(new Order(balloonColor,balloonSize,clientName,address));
        DataHolder.orderList.add(order);
        return order;
    }
    public List<Order> listAll()
    {
        return DataHolder.orderList;
    }
}
