package Servlet;

import Domain.User;
import Service.Impl.UserServiceImpl;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckServlet",value = "/checkUserName")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        if(username==null||username.trim().length()==0){
            return;
        }
        UserService userService = new UserServiceImpl();
        User user = userService.checked(username);
        System.out.println(user.toString());
        if(user!=null){
           response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
