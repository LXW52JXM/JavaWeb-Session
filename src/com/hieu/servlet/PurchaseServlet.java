package com.hieu.servlet;

import com.hieu.entity.Cake;
import com.hieu.entity.CakeDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet",urlPatterns = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        String id=req.getParameter("id");
        if (id == null) {
            //重新定向到主界面
            resp.sendRedirect("SessionServlet");
            return;
        }
        //获取商品信息
        Cake cake= CakeDb.getCakeByID(id);
        //创建Session或者获取用户的Session
        HttpSession session=req.getSession();
        //从session中获取购物车
        List<Cake> cakeList= (List) session.getAttribute("cakeList");
        if (cakeList == null) {
            //cakeList为空说明是首次购买,创建一个空的购物车
            cakeList=new ArrayList<Cake>();
            //将购物车放进session中
            session.setAttribute("cakeList",cakeList);
        }
        //把商品放进购物车
        cakeList.add(cake);
        //为了让购物车持久化
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/servlet");
        //resp.addCookie(cookie);
        //重定向到购物车页面
        resp.sendRedirect("CartServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
