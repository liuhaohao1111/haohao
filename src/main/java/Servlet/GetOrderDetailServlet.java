package Servlet;

import Domain.OrderDetail;
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

@WebServlet(name = "GetOrderDetailServlet",value = "/getOrderDetail")
public class GetOrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getSession().getAttribute("user");
        if(user==null) {
            response.sendRedirect("/login.jsp");
        }
        OrderDetail orderDetail = new OrderDetail();
        String oid = request.getParameter("oid");
        OrderService orderService = new OrderServiceImpl();
        List<OrderDetail> OrderDetail= orderService.query(oid);
        request.setAttribute("OrderDetlaiList",OrderDetail);
        request.setAttribute("orderDetail",orderDetail);
        request.getRequestDispatcher("/orderDetail.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
