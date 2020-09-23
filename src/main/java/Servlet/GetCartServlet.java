package Servlet;

import Domain.Carts;
import Domain.User;
import Service.CartsService;
import Service.Impl.CartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetServlet",value = "/getCart")
public class GetCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login.jsp");
        }
        CartsService cartsService = new CartsServiceImpl();
        List<Carts> carts = cartsService.findById(user.getId());
        request.setAttribute("carts",carts);
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
