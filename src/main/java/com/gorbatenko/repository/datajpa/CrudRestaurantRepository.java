package com.gorbatenko.repository.datajpa;

import com.gorbatenko.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Restaurant save(Restaurant restaurant);

    @Query("SELECT r FROM Restaurant r ORDER BY r.name DESC")
    List<Restaurant> getAll();

    @Override
    Optional<Restaurant> findById(Integer id);

    @Query("SELECT r FROM Restaurant r WHERE lower(r.name) like lower(concat('%', :name,'%')) ORDER BY r.name DESC")
    List<Restaurant> getByName(@Param("name") String name);

}


