package me.dio.cart.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.cart.enumeration.PaymentMethods;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Entity // an entity represents a table in a relational database
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // id=1, id=2, id=3...
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) // a customer can have multiple shopping carts
    @JsonIgnore
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
    private Double total;
    @Enumerated
    private PaymentMethods paymentMethods;
    private boolean closed;
}