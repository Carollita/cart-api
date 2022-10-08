package me.dio.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.cart.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}