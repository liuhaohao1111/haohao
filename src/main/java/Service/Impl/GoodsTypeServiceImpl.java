package Service.Impl;

import Dao.GoodsTypeDao;
import Dao.Impl.GoodsTypeImpl;
import Domain.GoodsType;
import Service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDao goodsTypeDao = new GoodsTypeImpl();
    @Override
    public List<GoodsType> queryTypeBylevel(int level) {
        return goodsTypeDao.findTypeBylevel(level);
    }
}
