package Servlet;

import Domain.Carts;
import Domain.Goods;
import Domain.User;
import Service.CartsService;
import Service.GoodsService;
import Service.Impl.CartsServiceImpl;
import Service.Impl.GoodsServieImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet",value = "/addCart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断用户是否登录
        User user =(User) request.getSession().getAttribute("user");
        System.out.println(user.toString());
        if(user==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //获取参数
        int id = Integer.parseInt(request.getParameter("goodsId"));
        String price = request.getParameter("price");
        //2.添加到购物车
        //2.1判断购物车内是否有该商品，根据uid和PID查询购物车是否有该商品
        CartsService cartsService = new CartsServiceImpl();
        Carts cart = cartsService.findByUidAndUid(user.getId(), id);
        GoodsService goodsService = new GoodsServieImpl();
        Goods goods = goodsService.findById(id);
        if(cart==null){
            //添加
            cart = new Carts(user.getId(),id,1,goods.getPrice());
            cartsService.insert(cart);
            request.getRequestDispatcher("/cartSuccess.jsp").forward(request,response);
        }else{
            //更新
            cart.setNum(cart.getNum()+1);
            cart.setMoney(goods.getPrice()*cart.getNum());
            cartsService.update(cart);
            request.getRequestDispatcher("/cartSuccess.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
