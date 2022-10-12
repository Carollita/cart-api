package me.dio.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.cart.model.Product;

@Repository
public interface ItemRepository extends JpaRepository<Product, Long> {
}