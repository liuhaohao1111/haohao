package Servlet;

import Domain.GoodsType;
import Service.GoodsTypeService;
import Service.Impl.GoodsTypeServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet(name = "GoodsTypeServlet",value = "/goodstypeservlet")
public class GoodsTypeServlet extends BaseServlet {
    public String goodstypelist(HttpServletRequest request,HttpServletResponse response)throws Exception{
        response.setContentType("application/json;charset=utf-8");
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsType> goodsTypes = goodsTypeService.queryTypeBylevel(1);
        String str = JSON.toJSONString(goodsTypes);
        response.getWriter().write(str);
        return null;
    }

}
