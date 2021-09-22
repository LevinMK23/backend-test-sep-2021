package com.geekbrains.fabric;

public class CatFabric extends AnimalFabric {

    @Override
    public Cat create() {
        return new Cat();
    }
}
