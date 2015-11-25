/*
 * Controller for internet store
 */

package com.istore.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.istore.data.CartItem;
import com.istore.data.CartService;
import com.istore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.istore.data.IstoreService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IstoreController {

    @Autowired
    @Resource(name = "ProductIstoreService")
    IstoreService products;

    @Autowired
    @Resource(name = "CartServiceImpl")
    CartService cart;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String catalog(@RequestParam(value = "product2cart", required=false) Integer pid, ModelMap model) {

        if (pid != null) {
            Product product = (Product) products.getItemById(pid);

            //добавляем в корзину элемент
            CartItem ci = new CartItem();
            ci.aid = product.getAid();
            cart.addCartItem(ci);

            //увеличиваем сумму покупок в корзине на стоимость добавленного продукта
            cart.setSumm(cart.getSumm() + product.getPrice());
        }

        List<?> allProducts = products.getAllItems();
        model.addAttribute("products", allProducts);
        model.addAttribute("totalPrice", cart.getSumm());

        return "jsp/catalog.jsp";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(@RequestParam("id") Integer pid, ModelMap model) {

        Object product = products.getItemById(pid);
        model.addAttribute("product", product);

        return "jsp/product.jsp";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(@RequestParam("catid") Integer catid, ModelMap model) {

        List<?> catProducts = products.getCategoryItems(catid);
        model.addAttribute("products", catProducts);

        return "jsp/category.jsp";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(ModelMap model) {
        List<Product> products = new ArrayList<Product>();

        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem ci : cartItems) {
            Product p = (Product) this.products.getItemById(ci.aid);
            products.add(p);
        }

        //отображаем содержимое корзины
        model.addAttribute("products", products);
        model.addAttribute("totalPrice", cart.getSumm());
        return "jsp/cart.jsp";
    }

    @RequestMapping(value = "/check_out", method = RequestMethod.GET)
    public String checkOut(ModelMap model) {
        List<CartItem> cartItems = cart.getCartItems();
        //очищаем корзину
        cart.clean();
        //обновляем остатки
        for (CartItem ci : cartItems) {
            Product prod = (Product) this.products.getItemById(ci.aid);
            Integer amount = prod.getAmount();
            if (amount > 0) {
                amount--;
                prod.setAmount(amount);
            }

            products.save(prod);
        }

        List<?> allProducts = products.getAllItems();
        model.addAttribute("products", allProducts);
        model.addAttribute("totalPrice", cart.getSumm());

        return "jsp/catalog.jsp";
    }
}