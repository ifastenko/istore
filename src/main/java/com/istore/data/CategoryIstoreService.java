package com.istore.data;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CategoryIstoreService")
public class CategoryIstoreService implements IstoreService {

    @Autowired
    @Resource(name = "CategoryIstoreDAO")
    private IstoreDAO categoryDAO;

    @Transactional
    public List<?> getAllItems() {
        return categoryDAO.getAllItems();
    }
}
