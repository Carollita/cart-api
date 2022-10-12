package me.dio.cart.service;

import me.dio.cart.model.Cart;
import me.dio.cart.model.Item;
import me.dio.cart.resource.dto.DtoItem;

public interface CartService {
    Item addItemToCart(DtoItem dtoItem);
    Cart viewCart(Long id);
    Cart proceedToCheckout(Long id, int paymentMethods);
}