package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final Users usersRepo = Users.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
        } else {
            response.sendRedirect("/user/hello.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null && !login.isEmpty() && !password.isEmpty()) {
            boolean validLogin = usersRepo.getUsers().contains(login);

            if (validLogin && password != null && !password.isEmpty()) {
                request.getSession().setAttribute("user", login);
                response.sendRedirect("/user/hello.jsp");
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}




