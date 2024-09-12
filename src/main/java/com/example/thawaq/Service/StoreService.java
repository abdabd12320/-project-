package com.example.thawaq.Service;

import com.example.thawaq.Api.ApiException;
import com.example.thawaq.Model.Store;
import com.example.thawaq.Model.StoreAdmin;
import com.example.thawaq.Repository.StoreAdminRepository;
import com.example.thawaq.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreAdminRepository storeAdminRepository;

    public List<Store> getStores()
    {
        return storeRepository.findAll();
    }

    public void addStore(Integer sID,Store store) // v2
    {
        StoreAdmin sa = storeAdminRepository.findStoreAdminById(sID);
        if(sa == null)
        {
            throw new ApiException("Store not found");
        }
        storeRepository.save(store);
        sa.setStore(store);
        storeAdminRepository.save(sa);
    }

    public void updateStore(Integer id,Store store)
    {
        Store s = storeRepository.findStoreById(id);
        if(s == null)
        {
            throw new ApiException("Store not found");
        }
        s.setName(store.getName());
        s.setTypeOfActivity(store.getTypeOfActivity());
        s.setPhoneNumber(store.getPhoneNumber());
        s.setCommercialRegister(store.getCommercialRegister());
        s.setRestaurantImage(store.getRestaurantImage());
        storeRepository.save(s);
    }
    public void deleteStore(Integer id)
    {
        if(storeRepository.findStoreById(id) == null)
        {
            throw new ApiException("Store not found");
        }
        storeRepository.deleteById(id);
    }
}
