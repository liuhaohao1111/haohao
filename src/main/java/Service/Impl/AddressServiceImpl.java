package Service.Impl;

import Dao.AddressDao;
import Dao.Impl.AddressDaoImpl;
import Domain.Address;
import Service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    AddressDao addressDao = new AddressDaoImpl();
    @Override
    public List<Address> queryAddressByUid(int uid) {
        return addressDao.findAddressByUid(uid);
    }

    @Override
    public void insertAddress(Address address) {
        addressDao.addAddress(address);
    }

    @Override
    public void deleteAddress(int id) {
        addressDao.deleteAddress(id);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }
}
