package mk.finki.ukim.mk.lab.web.controlers;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BallonnControler {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BallonnControler(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model, HttpServletRequest request){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Balloon> balloons = this.balloonService.listAll();
        Order order = new Order("","","","");
        request.getSession().setAttribute("order",order);
        model.addAttribute("balloons",balloons);
        return "listBalloons.html";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers",manufacturers);
        return "add-balloon.html";

    }


//    @GetMapping("/edit-form/{id}")
//    public String getEditBalloonPage(@PathVariable Long id, Model model){
//        if(this.balloonService.findById(id).isPresent()){
//            Balloon balloon = this.balloonService.findById(id).get();
//            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
//            model.addAttribute("manufacturers",manufacturers);
//            model.addAttribute("ballonn",balloon);
//            return "add-balloon";
//        }
//        return "redirect:/ballonns?error=BallonnNotFound";
//    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if(this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("balloon", balloon);
            return "add-balloon";
        }
        return "redirect:/balloons?error=BalloonNotFound";
    }



    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @PostMapping
    public String ballonnsPage(HttpServletRequest request, Model model){
        String balloonColor = request.getParameter("color");
        Order order = (Order) request.getSession().getAttribute("order");
        order.setBalloonColor(balloonColor);
        //request.getSession().setAttribute("balloonColor",balloonColor);
        //request.getSession().setAttribute("order",order);
        return "redirect:/selectBalloon";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name, @RequestParam String description,@RequestParam Long manufacturer){
        this.balloonService.save(name,description,manufacturer);
        return "redirect:/balloons";
    }

}
