package me.dio.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.cart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}