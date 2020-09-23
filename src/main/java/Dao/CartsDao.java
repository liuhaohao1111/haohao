package Dao;

import Domain.Carts;
import Domain.Goods;

import java.util.List;

public interface CartsDao {
    Carts findByUidAndUid(int uid, int pid);
    void addCarts(Carts carts);
    void update(Carts carts);
    //先通过用户id查询到购物车信息
    //在通过商品id查询到商品信息
    List<Carts> findById(int uid);
    void deleteonlyByPid(int pid);
    void deleteByPid(int uid, int pid);
    void removeAll(int uid);
}
