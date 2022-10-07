package me.dio.cart.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Embeddable 
@NoArgsConstructor
public class Address {
    private String zipCode;
    private String details;
}