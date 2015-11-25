package com.istore.data;

import java.util.List;

import com.istore.model.Category;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.istore.model.Product;

@Repository("ProductIstoreDAO")
public class ProductIstoreDAO implements IstoreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<?> getAllItems() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }

    public Object getItemById(Integer productid) {
        return sessionFactory.getCurrentSession().get(Product.class, productid);
    }

    public List<?> getCategoryItems(Integer catid) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Product.class);

        Category cat = (Category) sessionFactory.getCurrentSession().get(Category.class, catid);
        cr.add(Restrictions.eq("category",cat));

        return cr.list();
    }

    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }
}