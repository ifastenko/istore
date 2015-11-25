package com.istore.data;

import java.util.List;

import javax.annotation.Resource;

import com.istore.model.Product;
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

    @Transactional
    public Product getItemById(Integer productid) {
        return (Product)productDAO.getItemById(productid);
    }

    @Transactional
    public List<?> getCategoryItems(Integer catid) {
        return productDAO.getCategoryItems(catid);
    }

    public void save(Product product){
        productDAO.update(product);
    }
}