package Service;

import Domain.Carts;

import java.util.List;

public interface CartsService {
    Carts findByUidAndUid(int uid, int pid);
    void insert(Carts carts);
    void update(Carts carts);
    List<Carts> findById(int uid);
    void deleteonlyByPid(int pid);
    void deleteByPid(int id, int pid);
    void removeAll(int uid);
}
