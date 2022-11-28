package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //nemase nikakvi instrukcii za sto da implementirame za ovoj servis?
    @Override
    public Order placeOrder(String balloonColor, String balloonSize, String clientName, String address) {
        return orderRepository.placeOrder(balloonColor,balloonSize,clientName,address);
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.listAll();
    }
}
