package com.istore.data;

import com.istore.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface CartService {
    List<CartItem> cartItems = new ArrayList<CartItem>();
    Integer summ = 0;

    public void addCartItem(CartItem cartItem);

    public List<CartItem> getCartItems();

    public void setSumm(Integer summ);

    public Integer getSumm();

    public void clean();
}
