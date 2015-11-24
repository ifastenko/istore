package com.istore.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.istore.model.Product;

@Repository("ProductIstoreDAO")
public class ProductIstoreDAO implements IstoreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<?> getAllItems() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }
}