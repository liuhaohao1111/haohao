package Servlet;

import Domain.User;
import Service.Impl.UserServiceImpl;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/userLogin")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String useranme = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String vcode = (String) session.getAttribute("vcode");
        if(!code.equalsIgnoreCase(vcode)){
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
        UserService userService = new UserServiceImpl();
        User user = userService.login(useranme, password);
        if(user.getFlag()==0){
            return;
        }
        if(user!=null){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
