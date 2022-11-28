package mk.finki.ukim.mk.lab.web.controlers;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Controller
//@RequestMapping("/balloons")
//public class BallonnControler {
//
//    private final BalloonService balloonService;
//    private final ManufacturerService manufacturerService;
//    private  final OrderService orderService;
//
//    public BallonnControler(BalloonService balloonService, ManufacturerService manufacturerService, OrderService orderService) {
//        this.balloonService = balloonService;
//        this.manufacturerService = manufacturerService;
//        this.orderService = orderService;
//    }
//
//    @GetMapping
//    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
//        if(error != null && !error.isEmpty()){
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//        List<Balloon> balloons = this.balloonService.listAll();
//        int counter = balloonService.getCounter();
//        model.addAttribute("balloons",balloons);
//        model.addAttribute("counter",counter);
//        return "listBalloons.html";
//    }
//
//    @GetMapping("/add-form")
//    public String getAddBalloonPage(Model model){
//        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
//        model.addAttribute("manufacturers",manufacturers);
//        return "add-balloon.html";
//
//    }
//
//
////    @GetMapping("/edit-form/{id}")
////    public String getEditBalloonPage(@PathVariable Long id, Model model){
////        if(this.balloonService.findById(id).isPresent()){
////            Balloon balloon = this.balloonService.findById(id).get();
////            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
////            model.addAttribute("manufacturers",manufacturers);
////            model.addAttribute("ballonn",balloon);
////            return "add-balloon";
////        }
////        return "redirect:/ballonns?error=BallonnNotFound";
////    }
//
//    @GetMapping("/edit-form/{id}")
//    public String editProductPage(@PathVariable Long id, Model model) {
//        if(this.balloonService.findById(id).isPresent()){
//            Balloon balloon = this.balloonService.findById(id).get();
//            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
//            model.addAttribute("manufacturers", manufacturers);
//            model.addAttribute("balloon", balloon);
//            return "add-balloon";
//        }
//        return "redirect:/balloons?error=BalloonNotFound";
//    }
//
//
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteBalloon(@PathVariable Long id){
//        this.balloonService.deleteById(id);
//        return "redirect:/balloons";
//    }
//
//    @PostMapping
//    public String ballonnsPage(HttpServletRequest request, Model model){
//        String balloonColor = request.getParameter("color");
//        Order order = (Order) request.getSession().getAttribute("order");
//        order.setBalloonColor(balloonColor);
//        //request.getSession().setAttribute("balloonColor",balloonColor);
//        //request.getSession().setAttribute("order",order);
//        return "redirect:/selectBalloon";
//    }
//
//    @PostMapping("/add")
//    public String saveBalloon(@RequestParam String name, @RequestParam String description,@RequestParam Long manufacturer){
//        this.balloonService.save(name,description,manufacturer);
//        return "redirect:/balloons";
//    }
//
//    @PostMapping("/selectBalloon")
//    public String chosenColor(HttpServletRequest request, Model model)
//    {
//        String color = request.getParameter("color");
//        Order order = new Order(color,"","","");
//        request.getSession().setAttribute("order",order);
//        return "selectBalloonSize";
//    }
//    @PostMapping("/selectBalloonSize")
//    public String chosenSize(HttpServletRequest request, Model model)
//    {
//        String size = request.getParameter("size");
//        Order order = (Order) request.getSession().getAttribute("order");
//        order.setBalloonSize(size);
//        request.getSession().setAttribute("order",order);
//        return "deliveryInfo";
//    }
//    @PostMapping("/deliveryInfo")
//    public String deliveryInfo(HttpServletRequest request, Model model)
//    {
//        String clientName = request.getParameter("clientName");
//        String deliveryAddress = request.getParameter("clientAddress");
//        String ipAddress = request.getRemoteAddr();
//        String clientBrowser = request.getHeader("User-Agent");
//        Order order = (Order) request.getSession().getAttribute("order");
//        order.setClientName(clientName);
//        order.setClientAddress(deliveryAddress);
//        request.getSession().setAttribute("order",order);
//        orderService.placeOrder(order.getBalloonColor(),order.getBalloonSize(),order.getClientName(),order.getClientAddress());
//        model.addAttribute("ipAddress",ipAddress);
//        model.addAttribute("clientBrowser",clientBrowser);
//        return "confirmationInfo";
//    }
//    @GetMapping("/orders")
//    public String getOrdersPage(Model model)
//    {
//        List<Order> orders = orderService.listAll();
//        model.addAttribute("orders",orders);
//        return "userOrders";
//    }
//
//}
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//import java.util.Random;

@Controller
@RequestMapping("/balloons")
public class BallonnControler {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private final OrderService orderService;

    public BallonnControler(BalloonService balloonService, ManufacturerService manufacturerService, OrderService orderService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model)
    {
        List<Balloon> balloons = this.balloonService.listAll();
        int counter = balloonService.getCounter();
        model.addAttribute("balloons", balloons);
        model.addAttribute("counter",counter);
        return "listBalloons";
    }
    @GetMapping("/edit-balloon/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        if(this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("balloon", balloon);
            return "add-balloon";
        }
        return "redirect:/products?error=ProductNotFound";
    }
    @GetMapping("/add-balloon")
    public String getAddBalloonPage(Model model)
    {
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }
    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer)
    {
        this.balloonService.save(name,description, manufacturer);
        return "redirect:/balloons";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id)
    {
        balloonService.deleteById(id);
        return "redirect:/balloons";
    }
    @PostMapping("/selectBalloon")
    public String chosenColor(HttpServletRequest request, Model model)
    {
        String color = request.getParameter("color");
        Order order = new Order(color,"","","");
        request.getSession().setAttribute("order",order);
        return "selectBalloonSize";
    }
    @PostMapping("/selectBalloonSize")
    public String chosenSize(HttpServletRequest request, Model model)
    {
        String size = request.getParameter("size");
        Order order = (Order) request.getSession().getAttribute("order");
        order.setBalloonSize(size);
        request.getSession().setAttribute("order",order);
        return "deliveryInfo";
    }
    @PostMapping("/deliveryInfo")
    public String deliveryInfo(HttpServletRequest request, Model model)
    {
        String clientName = request.getParameter("clientName");
        String deliveryAddress = request.getParameter("clientAddress");
        String ipAddress = request.getRemoteAddr();
        String clientBrowser = request.getHeader("User-Agent");
        Order order = (Order) request.getSession().getAttribute("order");
        order.setClientName(clientName);
        order.setClientAddress(deliveryAddress);
        request.getSession().setAttribute("order",order);
        orderService.placeOrder(order.getBalloonColor(),order.getBalloonSize(),order.getClientName(),order.getClientAddress());
        model.addAttribute("ipAddress",ipAddress);
        model.addAttribute("clientBrowser",clientBrowser);
        return "confirmationInfo";
    }
    @GetMapping("/orders")
    public String getOrdersPage(Model model)
    {
        List<Order> orders = orderService.listAll();
        model.addAttribute("orders",orders);
        return "userOrders";
    }
}