package com.istore.data;

import com.istore.model.Product;

import java.util.List;

public interface IstoreService {
    public List<?> getAllItems();

    public Object getItemById(Integer itemid);

    public List<?> getCategoryItems(Integer catid);

    public void save(Product product);
}