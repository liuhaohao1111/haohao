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

@WebServlet(name = "UpdateAddressServlet",value = "/updateAddress")
public class UpdateAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user =(User) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");
        Address address = new Address(0,detail,name,phone,user.getId(),0);
        AddressService addressService = new AddressServiceImpl();
        addressService.updateAddress(address);
        System.out.println(address.toString());
        request.getRequestDispatcher("/getAddress").forward(request,response);
        System.out.println(address.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
