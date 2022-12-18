package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class InMemoryOrderRepository {

    public Order placeOrder(String balloonColor, String balloonSize, LocalDateTime dateCreated)
    {
        Order order=(new Order(balloonColor,balloonSize,dateCreated));
        DataHolder.orderList.add(order);
        return order;
    }
    public List<Order> listAll()
    {
        return DataHolder.orderList;
    }
}
