package Service.Impl;

import Dao.GoodsDao;
import Dao.GoodsTypeDao;
import Dao.Impl.GoodsDaoImpl;
import Dao.Impl.GoodsTypeImpl;
import Dao.UserDao;
import Domain.Goods;
import Domain.GoodsType;
import Domain.PageBean;
import Service.GoodsService;

import java.util.List;

public class GoodsServieImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<Goods> findByType(int typeid) {
        return goodsDao.findByType(typeid);
    }

    @Override
    public Goods findById(int gid) {
        Goods goods = goodsDao.findById(gid);
        //根据商品的类型id查询商品的类型
        GoodsTypeDao goodsTypeDao = new GoodsTypeImpl();
        GoodsType goodsType = goodsTypeDao.findByid(goods.getTypeid());
        goods.setGoodsType(goodsType);
        return goods;
    }
}
