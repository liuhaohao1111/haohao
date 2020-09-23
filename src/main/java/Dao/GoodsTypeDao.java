package Dao;

import Domain.Goods;
import Domain.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> findTypeBylevel(int level);
    GoodsType findByid(int typeid);
}
