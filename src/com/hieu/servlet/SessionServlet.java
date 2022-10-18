package com.hieu.servlet;

import com.hieu.entity.Cake;
import com.hieu.entity.CakeDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "SessionServlet",urlPatterns = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //获取全部信息
        Collection<Cake> cakes= CakeDb.getAll();
        writer.write("商品详细信息如下："+"</br>");
        for (Cake cake:cakes){
            String url="PurchaseServlet?id="+cake.getId();
            writer.write(cake.getName()+"<a href='"+url+"'>购买</a>"+"</br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
