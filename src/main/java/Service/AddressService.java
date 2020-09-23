package Service;

import Domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> queryAddressByUid(int uid);
    void insertAddress(Address address);
    void deleteAddress(int id);
    void updateAddress(Address address);
}
