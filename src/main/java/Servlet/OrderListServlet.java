package Servlet;

import Domain.Order;
import Domain.User;
import Service.Impl.OrderServiceImpl;
import Service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderListServlet",value = "/getOrderList")
public class OrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login.jsp");
        }
        Order order = new Order();
        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = orderService.query(user.getId());
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/orderList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
