package com.example.listener;

import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LocalDateTime servletTimeInit = LocalDateTime.now();
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("servletTimeInit", servletTimeInit);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
