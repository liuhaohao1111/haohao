package Servlet;

import Domain.Address;
import Domain.User;
import Service.AddressService;
import Service.Impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAddressServlet",value = "/getAddress")
public class GetAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login.jsp");
        }
        AddressService addressService = new AddressServiceImpl();
        List<Address> addList = addressService.queryAddressByUid(user.getId());
        request.setAttribute("addList",addList);
        request.getRequestDispatcher("/self_info.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
