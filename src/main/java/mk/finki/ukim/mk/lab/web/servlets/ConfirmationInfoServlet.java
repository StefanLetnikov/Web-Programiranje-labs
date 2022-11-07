package mk.finki.ukim.mk.lab.web.servlets;


import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="confirmation-info-servlet", urlPatterns ="/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp, req.getServletContext());
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        context.setVariable("ipAddress",ipAddress);
        context.setVariable("clientAgent",clientAgent);// kako da go zemam samo browserot?
        this.springTemplateEngine.process("confirmationInfo.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/logout");
    }
}
