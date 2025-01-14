package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(Long id) {

        return this.fruitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fruit> getByPriceAsc() {

        return this.fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {

        return this.fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String term) {

        return this.fruitRepository.searchByName(term);
    }

    @Override
    public Fruit save(Fruit fruit) {

        return this.fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {

        Fruit fruitToDelete = getById(id);

        this.fruitRepository.delete(fruitToDelete);

        return fruitToDelete;
    }
}
