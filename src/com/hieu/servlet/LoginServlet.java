package com.hieu.servlet;

import com.hieu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        if ("123".equals(name)&&"123".equals(password)) {
            HttpSession session=req.getSession();
            User user=new User();
            user.setName(name);
            user.setPassword(password);
            session.setAttribute("user",user);
            resp.sendRedirect("IndexServlet");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
