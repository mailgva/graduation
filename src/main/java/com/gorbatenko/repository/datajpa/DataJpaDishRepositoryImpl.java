package com.gorbatenko.repository.datajpa;

import com.gorbatenko.model.Dish;
import com.gorbatenko.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataJpaDishRepositoryImpl implements DishRepository {
    @Autowired
    private CrudDishRepository crudDishRepository;

    @Override
    public Dish save(Dish dish) {
        return crudDishRepository.save(dish);
    }

    @Override
    public boolean delete(int id) {
        return crudDishRepository.delete(id) != 0;
    }

    @Override
    public Dish get(int id) {
        return crudDishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish getByName(String name) {
        return null;
    }

    @Override
    public List<Dish> getAll() {
        return null;
    }
}
