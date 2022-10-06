package me.dio.cart.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import me.dio.cart.enumeration.PaymentMethods;

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
    private List<Item> item;
    private Double total;
    @Enumerated
    private me.dio.cart.enumeration.PaymentMethods PaymentForms;
    private boolean closed;

    /* Constructor, getters and setters
    public Cart() {
    } // *@NoArgsConstructor

    public Cart(Long id, Customer customer, List<Item> item, Double total, me.dio.cart.enumeration.PaymentMethods paymentForms, boolean closed) {
        this.id = id;
        this.customer = customer;
        this.item = item;
        this.total = total;
        PaymentForms = paymentForms;
        this.closed = closed;
    } // *@AllArgsConstructor

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public me.dio.cart.enumeration.PaymentMethods getPaymentForms() {
        return PaymentForms;
    }

    public void setPaymentForms(me.dio.cart.enumeration.PaymentMethods paymentForms) {
        PaymentForms = paymentForms;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    } // *@Data
    */
}