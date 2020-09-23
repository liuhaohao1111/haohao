package Servlet;

import Domain.Carts;
import Domain.Order;
import Domain.OrderDetail;
import Domain.User;
import Service.CartsService;
import Service.Impl.CartsServiceImpl;
import Service.Impl.OrderServiceImpl;
import Service.OrderService;
import utils.RandomUtils;
import utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet",value = "/addOrder")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login.jsp");
        }
        int aid = Integer.parseInt(request.getParameter("aid"));
        //1.获取购物车里商品的信息
        CartsService cartsService = new CartsServiceImpl();
        List<Carts> carts = cartsService.findById(user.getId());
        //2.创建一个订单号
        String oid = RandomUtils.createOrderId();
        //3.遍历出来购物车里的商品信息
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        int money=0;
        for (Carts cart : carts) {
            //创建订单详情
            OrderDetail orderDetail = new OrderDetail(0,oid,cart.getPid(),cart.getNum(),cart.getMoney());
            //将订单详情放入集合
            orderDetails.add(orderDetail);
            money= money+cart.getMoney();
        }
        //4.创建订单
        Order order = new Order(oid,user.getId(),money,"1",new Date(),aid);
        OrderService orderService = new OrderServiceImpl();
        orderService.save(order,orderDetails);
        request.setAttribute("order",order);
        request.getRequestDispatcher("/orderSuccess.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
