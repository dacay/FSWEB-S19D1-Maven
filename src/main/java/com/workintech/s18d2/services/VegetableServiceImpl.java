package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;

public class VegetableServiceImpl {

    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {

        this.vegetableRepository = vegetableRepository;
    }
}
