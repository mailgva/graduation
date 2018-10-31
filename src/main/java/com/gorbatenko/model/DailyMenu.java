package com.gorbatenko.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "daily_menu")
public class DailyMenu extends AbstractBaseEntity {
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@NotNull(groups = View.Persist.class)
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@NotNull(groups = View.Persist.class)
    private Restaurant restaurant;

    public DailyMenu(LocalDate date, Dish dish, Restaurant restaurant) {
        this.date = date;
        this.dish = dish;
        this.restaurant = restaurant;
    }

    public DailyMenu(Integer id, LocalDate date, Dish dish, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.dish = dish;
        this.restaurant = restaurant;
    }

    public DailyMenu() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

     public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "DailyMenu{" +
                "date=" + date +
                ", dish=" + dish +
                ", id=" + id +
                '}';
    }
}
