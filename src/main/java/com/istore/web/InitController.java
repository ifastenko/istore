package com.istore.web;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import org.hibernate.SQLQuery;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InitController {

    @Autowired
    SessionFactory sessionFactory;

    //@javax.annotation.Resource
    //@Qualifier("contents")
    //String content;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @Transactional
    public String init() {

        //SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(content);
        //createSQLQuery.executeUpdate();

        return "ok";
    }
}