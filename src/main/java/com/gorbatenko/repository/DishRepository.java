package com.gorbatenko.repository;

import com.gorbatenko.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish save(Dish dish);

    // false if not found
    boolean delete(int id);

    // null if not found
    Dish get(int id);

    // null if not found
    Dish getByName(String name);

    List<Dish> getAll();
}
