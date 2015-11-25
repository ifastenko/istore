package com.istore.data;

import com.istore.model.Product;

import java.util.List;

public interface IstoreDAO {
    public List<?> getAllItems();

    public Object getItemById(Integer id);

    public List<?> getCategoryItems(Integer catid);

    public void update(Product product);
}