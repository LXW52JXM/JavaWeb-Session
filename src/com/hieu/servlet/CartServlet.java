package com.hieu.servlet;

import com.hieu.entity.Cake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //创建一个list存用户的购物车
        List<Cake> cakeList=null;
        //创建一个标志位，判断每次点击传过来的值是否重复相同
        boolean flag=true;
        //获取用户的session,加上FALSE为空不自动创建
        HttpSession session= req.getSession(false);
        if (session == null) {
            flag=false;
        }else {
            //session判断不为空，下面这个判断传过来的商品值是否为空
            //获取用户的购物车
            cakeList=(List)session.getAttribute("cakeList");
            if (cakeList == null) {
                //为空标志位为false
                flag=false;
            }
        }

        if (flag) {
            out.write("购买的商品详情："+"</br>");
            for (Cake cake:cakeList) {
                out.write(cake.getName()+"</br>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
