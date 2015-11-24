package com.istore.data;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ProductIstoreService")
public class ProductIstoreService implements IstoreService {

    @Autowired
    @Resource(name = "ProductIstoreDAO")
    private IstoreDAO productDAO;

    @Transactional
    public List<?> getAllItems() {
        return productDAO.getAllItems();
    }
}