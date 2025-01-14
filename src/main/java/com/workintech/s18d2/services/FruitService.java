package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {

    public Fruit getById(Long id);

    public List<Fruit> getByPriceAsc();

    public List<Fruit> getByPriceDesc();

    public List<Fruit> searchByName(String term);

    public Fruit save(Fruit fruit);

    public Fruit delete(Long id);
}
