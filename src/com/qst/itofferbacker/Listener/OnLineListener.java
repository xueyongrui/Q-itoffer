package com.qst.itofferbacker.Listener;

import com.qst.itofferbacker.javabean.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class OnLineListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    public OnLineListener() {
    }
    public void contextInitialized(ServletContextEvent sce) {
    }
    public void contextDestroyed(ServletContextEvent sce) {
    }
    public void sessionCreated(HttpSessionEvent se) {
    }
    public void sessionDestroyed(HttpSessionEvent se) {
        Enumeration e = se.getSession().getAttributeNames();
        while(e.hasMoreElements()) {
            if ("SESSION_USER".equals(e.nextElement())){
                User user = (User)se.getSession().getAttribute("SESSION_USER");
                ServletContext application = se.getSession().getServletContext();
                Map map = (Map)application.getAttribute("ONLINE");
                map.remove(user.getUserId());
            }
        }
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        if ("SESSION_USER".equals(sbe.getName())) {
            HttpSession session = sbe.getSession();
            User user = (User)session.getAttribute("SESSION_USER");
            ServletContext application = session.getServletContext();
            Map map = (Map)application.getAttribute("ONLINE");
            if (map != null) {
                map.put(user.getUserId(),user);
            } else {
                map = new HashMap();
                map.put(user.getUserId(),user);
                application.setAttribute("ONLINE", map);
            }
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
    }
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
    }
}
