package com.hieu.servlet;

import com.hieu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet",urlPatterns = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session=req.getSession();
        User user=(User) session.getAttribute("user");
        if (user == null) {
            resp.getWriter().write("请先登录！"+"<a href='"+"/JavaWeb_Session/Login.html"+"'>登录</a>");
        }else {
            //登录成功
            //session持久化
            Cookie cookie=new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(30*60);
            cookie.setPath("/JavaWeb_Session");
            resp.addCookie(cookie);
            resp.sendRedirect("SessionServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
