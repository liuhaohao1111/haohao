package Service.Impl;

import Dao.CartsDao;
import Dao.Impl.CartsDaoImpl;
import Domain.Carts;
import Domain.Goods;
import Service.CartsService;
import Service.GoodsService;

import java.util.List;

public class CartsServiceImpl implements CartsService {
    CartsDao cartsDao = new CartsDaoImpl();
    @Override
    public Carts findByUidAndUid(int uid, int pid) {
        return cartsDao.findByUidAndUid(uid, pid);
    }

    @Override
    public void insert(Carts carts) {
        cartsDao.addCarts(carts);
    }

    @Override
    public void update(Carts carts) {
        cartsDao.update(carts);
    }

    @Override
    public List<Carts> findById(int uid) {
        List<Carts> carts = cartsDao.findById(uid);
        //根据商品id查询商品信息
        if(carts!=null){
            GoodsService goodsService = new GoodsServieImpl();
            for (Carts cart : carts) {
                Goods goods = goodsService.findById(cart.getPid());
                cart.setGoods(goods);
            }
        }
        return carts;
    }

    @Override
    public void deleteonlyByPid(int pid) {
        cartsDao.deleteonlyByPid(pid);
    }

    @Override
    public void deleteByPid(int id,int pid) {
        cartsDao.deleteByPid(id,pid);
    }

    @Override
    public void removeAll(int uid) {
        cartsDao.removeAll(uid);
    }
}
