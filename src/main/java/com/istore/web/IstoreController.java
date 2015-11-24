/*
 * Контроллер веб-приложения
 */

package com.istore.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.istore.data.IstoreService;

@Controller
public class IstoreController {

    @Autowired
    @Resource(name = "ProductIstoreService")
    IstoreService products;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String catalog(ModelMap model) {

        List<?> allProducts = products.getAllItems();
        model.addAttribute("products", allProducts);

        return "jsp/catalog.jsp";
    }
}