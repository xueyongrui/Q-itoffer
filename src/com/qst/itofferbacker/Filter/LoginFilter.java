package com.qst.itofferbacker.Filter;

import com.qst.itofferbacker.javabean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/manage/*"})
public class LoginFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获得request，response，session对象
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpSession session = servletRequest.getSession();
        if ("UserServlet".equals((servletRequest.getServletPath())) && "type=login".equals(servletRequest.getQueryString())) {
            chain.doFilter(req, resp);
            return;
        } else {
            //从session里面获取用户
            User user = (User) session.getAttribute("SESSION_USER");
            if (user == null) {
                PrintWriter out = resp.getWriter();
                servletResponse.sendRedirect(servletRequest.getContextPath() + "/login.html");
            } else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
