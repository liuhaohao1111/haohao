package Servlet;

import Domain.Goods;
import Service.GoodsService;
import Service.Impl.GoodsServieImpl;
import utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodsdetailServlet",value = "/getGoodsById")
public class GoodsdetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GoodsService goodsService = new GoodsServieImpl();
        Goods goods= goodsService.findById(id);
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("/goodsDetail.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
