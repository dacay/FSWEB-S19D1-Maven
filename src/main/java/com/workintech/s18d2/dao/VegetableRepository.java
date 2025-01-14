package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VegetableRepository extends CrudRepository<Vegetable, Long> {

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    public List<Vegetable> getByPriceDesc();

    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    public List<Vegetable> getByPriceAsc();

    @Query("SELECT v FROM Vegetable v WHERE v.name LIKE %:term%")
    public List<Vegetable> searchByName(@Param("term") String term);
}
