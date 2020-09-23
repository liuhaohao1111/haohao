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

@WebServlet(name = "UpdateCartNumServlet",value = "/updateCartNum")
public class UpdateCartNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login.jsp");
        }
        int pid = Integer.parseInt(request.getParameter("pid"));
        int num=Integer.parseInt(request.getParameter("num"));
        int price = Integer.parseInt(request.getParameter("price"));
        //查询购物车里是否有该商品
        CartsService cartsService = new CartsServiceImpl();
        Carts cart = cartsService.findByUidAndUid(user.getId(),pid);
        if(cart!=null) {
            if (num == 0) {
                //删除
                cartsService.deleteByPid(user.getId(),pid);
            } else {
                //更新
                cart.setNum(cart.getNum()+num);
                cart.setMoney(price*cart.getNum());
                cartsService.update(cart);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
