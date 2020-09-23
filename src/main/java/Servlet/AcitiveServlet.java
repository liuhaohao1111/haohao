package Servlet;

import Service.Impl.UserServiceImpl;
import Service.UserService;
import utils.Base64Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AcitiveServlet",value = "/activate")
public class AcitiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String email = request.getParameter("e");
        String code = request.getParameter("c");
        UserService userService = new UserServiceImpl();
        if(userService.activtion(Base64Utils.decode(email),Base64Utils.decode(code))){
             request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            System.out.println("激活失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
