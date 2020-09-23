package Service;

import Domain.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> queryTypeBylevel(int level);
}
