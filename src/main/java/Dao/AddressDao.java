package Dao;

import Domain.Address;

import java.util.List;

public interface AddressDao {
    List<Address> findAddressByUid(int uid);
    //添加地址
    void addAddress(Address address);
    void deleteAddress(int id);
    void updateAddress(Address address);
    Address findAddressById(int id);
}
