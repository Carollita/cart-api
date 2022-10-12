package me.dio.cart.resource;

import lombok.RequiredArgsConstructor;
import me.dio.cart.model.Item;
import me.dio.cart.model.Cart;
import me.dio.cart.resource.dto.DtoItem;
import me.dio.cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@Api(value = "/ifood-devweek/cart")
@RestController
@RequestMapping("/ifood-devweek/cart")
@RequiredArgsConstructor
public class CartResource {
  private final CartService cartService;

  @PostMapping
  public Item addItemToCart(@RequestBody DtoItem dtoItem) {
    return cartService.addItemToCart(dtoItem);
  }

  // Postman: http://localhost:8080/ifood-devweek/cart?Content-Type=application/json
  // Key: Content-Type Value: application/json

  /*
  {
    "productId": 1,
    "quantity": 3,
    "cartId": 1
}
*/

  @GetMapping("/{id}")
  public Cart viewCart(@PathVariable("id") Long id) {
    return cartService.viewCart(id);
  }
    // Postman: http://localhost:8080/ifood-devweek/cart/1

  @PatchMapping("/proceed-to-checkout/{cartId}")
  public Cart proceedToCheckout(@PathVariable("cartId") Long cartId,
                             @RequestParam("paymentMethods") int paymentMethods) {
    return cartService.proceedToCheckout(cartId, paymentMethods);
  }
    // Postman: http://localhost:8080/ifood-devweek/cart/proceed-to-checkout/1?paymentMethods=0
    // Key: paymentMethods Value: 1
}