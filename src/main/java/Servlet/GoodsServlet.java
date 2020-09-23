package Servlet;

import Domain.Goods;
import Service.GoodsService;
import Service.Impl.GoodsServieImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsServlet",value = "/getGoodsListByTypeId")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeid = Integer.parseInt(request.getParameter("typeid"));
        GoodsService goodsService = new GoodsServieImpl();
        List<Goods> goods = goodsService.findByType(typeid);
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
