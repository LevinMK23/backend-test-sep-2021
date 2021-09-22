package com.geekbrains.fabric;

public class DogFabric extends AnimalFabric {

    @Override
    public Dog create() {
        return new Dog();
    }
}
