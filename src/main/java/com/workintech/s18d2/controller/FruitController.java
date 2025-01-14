package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.FruitException;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/workintech/fruits")
    public List<Fruit> getAllFruits() {

        return fruitService.getByPriceAsc();
    }

    @GetMapping("/workintech/fruits/{fruitId}")
    public Fruit getFruitById(@PathVariable Long fruitId) throws FruitException {

        if (fruitId < 0)
            throw new FruitException("ID is incorrect.");

        Fruit fruit =  fruitService.getById(fruitId);

        if (fruit == null)
            throw new FruitException("Fruit not found.");

        return fruit;
    }

    @GetMapping("/workintech/fruits/desc")
    public List<Fruit> getAllFruitsDesc() {

        return fruitService.getByPriceDesc();
    }

    @PostMapping("/workintech/fruits")
    public void saveOrUpdate(@RequestBody Fruit fruit) {

        fruitService.save(fruit);
    }

    @PostMapping("/workintech/fruits/{term}")
    public List<Fruit> searchByName(@PathVariable String term) {

        return fruitService.searchByName(term);
    }

    @DeleteMapping("/workintech/fruits/{fruitId}")
    public Fruit deleteFruitById(@PathVariable Long fruitId) throws FruitException {

        if (fruitId < 0)
            throw new FruitException("ID is incorrect.");

        return fruitService.delete(fruitId);
    }
}
