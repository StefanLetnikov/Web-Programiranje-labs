package mk.finki.ukim.mk.lab.web.servlets;


import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name="baloon-servlet", urlPatterns = "/servlet/ballonns")
public class BalloonListSevlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BalloonService balloonService;


    public BalloonListSevlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        WebContext context = new WebContext(req,resp, req.getServletContext());
        context.setVariable("balloons", this.balloonService.listAll());
        this.springTemplateEngine.process("listBalloons.html",context,resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balloonColor = req.getParameter("color");
        //kreiraj poceten order koj ke se prenesuva od eden state vo drug preku sesija
        Order order = new Order(balloonColor,"","","");
        WebContext context = new WebContext(req,resp,req.getServletContext());
        req.getSession().setAttribute("order",order);
        resp.sendRedirect("/selectBalloon");
    }

}
