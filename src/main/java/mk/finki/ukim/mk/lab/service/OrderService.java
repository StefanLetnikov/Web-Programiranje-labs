package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(String balloonColor, String balloonSize, LocalDateTime dateCreated);
    List<Order> listAll();
    Optional<Order> findById(Long id);
    List<Order> findAllByFilterDate(LocalDateTime dateFrom, LocalDateTime dateTo);
}
