package com.gorbatenko.repository;

import com.gorbatenko.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restaurant get(int id);

    // null if not found
    List<Restaurant> getByName(String name);

    List<Restaurant> getAll();
}
