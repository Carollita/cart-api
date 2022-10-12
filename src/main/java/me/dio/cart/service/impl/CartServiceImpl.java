package me.dio.cart.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.cart.enumeration.PaymentMethods;
import me.dio.cart.model.Cart;
import me.dio.cart.model.Item;
import me.dio.cart.model.Restaurant;
import me.dio.cart.repository.CartRepository;
import me.dio.cart.repository.ProductRepository;
import me.dio.cart.resource.dto.DtoItem;
import me.dio.cart.service.CartService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public Item addItemToCart(DtoItem dtoItem) {
      Cart cart = viewCart(dtoItem.getCartId());

      if (cart.isClosed()) {
        throw new RuntimeException("Este carrinho está fechado.");
      }

    Item addingItem = Item.builder()
        .quantity(dtoItem.getQuantity())
        .cart(cart)
        .product(productRepository.findById(dtoItem.getProductId()).orElseThrow(
            () -> {
              throw new RuntimeException("Este produto não existe!");
            }
        ))
        .build();

    List<Item> shoppingCartItems = cart.getItems();
    if (shoppingCartItems.isEmpty()) {
      shoppingCartItems.add(addingItem);
    } else {
      Restaurant currentChosenRestaurant = shoppingCartItems.get(0).getProduct().getRestaurant();
      Restaurant chosenRestaurantAdded = addingItem.getProduct().getRestaurant();
      if (currentChosenRestaurant.equals(chosenRestaurantAdded)) {
        shoppingCartItems.add(addingItem);
      } else {
        throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferentes. Feche ou esvazie o carrinho.");
      }
    }

    List<Double>itemsValue = new ArrayList<>();
    for (Item shoppingCartItem : shoppingCartItems) {
      double itemTotalValue = shoppingCartItem.getProduct().getUnitPrice() * shoppingCartItem.getQuantity();
      itemsValue.add(itemTotalValue);
    }

    Double shoppingCartTotalValue = itemsValue.stream()
        .mapToDouble(unitItemValue -> unitItemValue)
        .sum();
    
    cart.setTotal(shoppingCartTotalValue);

    cartRepository.save(cart);
    return addingItem;
  }

  @Override
  public Cart viewCart(Long id) {
    return cartRepository.findById(id).orElseThrow(
        () -> {
          throw new RuntimeException("Este carrinho não existe!");
        }
    );
  }

    @Override
    public Cart proceedToCheckout(Long id, int numberPaymentMethods) {
      Cart cart = viewCart(id);
      if (cart.getItems().isEmpty()) {
        throw new RuntimeException("Adicione itens no carrinho!");
      }

    PaymentMethods paymentMethods =
        numberPaymentMethods == 0 ? PaymentMethods.CASH : PaymentMethods.CREDITCARD;
    cart.setPaymentMethods(paymentMethods);
    cart.setClosed(true);
    return cartRepository.save(cart);
  }
}