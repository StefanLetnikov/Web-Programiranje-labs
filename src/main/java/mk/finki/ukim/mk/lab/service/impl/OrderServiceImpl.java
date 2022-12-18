package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.InMemoryOrderRepository;
import mk.finki.ukim.mk.lab.repository.jpa.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //nemase nikakvi instrukcii za sto da implementirame za ovoj servis?
    @Override
    public Order placeOrder(String balloonColor, String balloonSize, LocalDateTime dateCreated) {
        Order c = new Order(balloonColor, balloonSize, dateCreated);
        orderRepository.save(c);
        return c;
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllByFilterDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return orderRepository.findAllByDateCreatedBetween(dateFrom, dateTo);

    }
}
