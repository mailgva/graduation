package com.gorbatenko.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity {
    @ManyToOne
    @JoinColumn(name = "rest_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @Column(name = "price", nullable = false)
    @Range(min = 20, max = 2500)
    @NotNull
    private BigDecimal price;


    public Dish(Restaurant restaurant, BigDecimal price) {
        this.restaurant = restaurant;
        this.price = price;
    }

    public Dish(Integer id, String name, Restaurant restaurant, BigDecimal price) {
        super(id, name);
        this.restaurant = restaurant;
        this.price = price;
    }

    public Dish() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
