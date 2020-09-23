package Dao;

import Domain.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> findByType(int typeid);
    Goods findById(int gid);
}
