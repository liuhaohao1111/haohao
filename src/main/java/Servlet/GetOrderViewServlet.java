package Servlet;

import Domain.Address;
import Domain.Carts;
import Domain.User;
import Service.AddressService;
import Service.CartsService;
import Service.Impl.AddressServiceImpl;
import Service.Impl.CartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetOrderViewServlet",value = "/getOrderView")
public class GetOrderViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login.jsp");
        }
        //查询购物车商品的信息
        CartsService cartsService = new CartsServiceImpl();
        List<Carts> carts = cartsService.findById(user.getId());
        request.setAttribute("carts",carts);
        //根据uid查询地址信息
        AddressService addressService = new AddressServiceImpl();
        List<Address> addList = addressService.queryAddressByUid(user.getId());
        request.setAttribute("addList",addList);
        request.getRequestDispatcher("/order.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
