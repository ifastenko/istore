package com.istore.data;

import com.istore.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CartServiceImpl")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    List<CartItem> cartItems = new ArrayList<CartItem>();
    Integer summ = 0;

    public void addCartItem(CartItem ci) {
        cartItems.add(ci);
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public void setSumm(Integer summ) {
        this.summ = summ;
    }

    public Integer getSumm() {
        return this.summ;
    }

    public void clean() {
        this.cartItems = new ArrayList<CartItem>();
        this.summ = 0;
    }
}