package mk.finki.ukim.mk.lab.web.filter;

import mk.finki.ukim.mk.lab.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("user");

        String path = request.getServletPath();

        if (!path.equals("/login") &&
                !path.equals("/register") &&
                !path.equals("/h2") &&
                !path.equals("/main.css") &&
                user == null) {
            response.sendRedirect("/login");
        } else
            filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

}
