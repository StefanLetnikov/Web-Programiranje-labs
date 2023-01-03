package mk.finki.ukim.mk.lab.web.controlers;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrderPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Order> orders = orderService.listAll();
        model.addAttribute("orders", orders);
        return "userOrders.html";
    }

    @PostMapping("/select-color")
    public String addColor(@RequestParam String color, HttpServletRequest request) {
        if (color == null || color.isEmpty()) {

        }
        request.getSession().setAttribute("color", color);
        return "selectBalloonSize";
    }

    @PostMapping("/select-size")
    public String addSize(@RequestParam String size, HttpServletRequest request) {
        if (size == null || size.isEmpty()) {

        }
        Order order = (Order) request.getSession().getAttribute("order");
        order.setBalloonSize(size);
        //request.getSession().setAttribute("size", size);
        return "deliveryInfo";
    }

    @PostMapping("/select-date")
    public String addDate(@RequestParam("dateCreated") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateCreated, HttpServletRequest request) {
        request.getSession().setAttribute("dateCreated", dateCreated);
        return "confirmationInfo";
    }

    @PostMapping("/confirm")
    public String confirm(HttpServletRequest request, Model model) {
        Order order = (Order) request.getSession().getAttribute("order");
        orderService.placeOrder(order.getBalloonColor(), order.getBalloonSize(), order.getDateCreated());
        return "redirect:/orders";
    }

    @GetMapping("/filter")
    public String filterByDate(@RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                               @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo,
                               Model model) {
        List<Order> orders = orderService.findAllByFilterDate(dateFrom, dateTo);
        model.addAttribute("orders", orders);
        return "userOrders.html";
    }

}
