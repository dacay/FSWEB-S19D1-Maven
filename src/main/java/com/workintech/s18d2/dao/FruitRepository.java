package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FruitRepository extends CrudRepository<Fruit, Long> {

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    public List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    public List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE f.name LIKE %:term%")
    public List<Fruit> searchByName(@Param("term") String term);
}
