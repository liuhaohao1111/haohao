package Servlet;

import Domain.User;
import Service.Impl.UserServiceImpl;
import Service.UserService;
import utils.EmailUtils;
import utils.RandomUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",value = "/userRegister")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        User user = new User(0,username, password, email, gender, 0, 1, RandomUtils.createActive());
        UserService service = new UserServiceImpl();
        if(service.register(user)>0){
            request.getSession().setAttribute("registerUser", user);
            //发送激活邮件
            EmailUtils.sendEmail(user);
            //跳转到 注册成功页面
            response.sendRedirect("registerSuccess.jsp");
        }else{
            request.getSession().setAttribute("registerMsg", "注册失败");
            response.sendRedirect("register.jsp");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
