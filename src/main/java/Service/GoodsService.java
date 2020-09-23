package Service;

import Domain.Goods;
import Domain.PageBean;

import java.util.List;

public interface GoodsService {
    List<Goods> findByType(int typeid);
    Goods findById(int gid);
}
