package com.geekbrains.fabric;

public class AnimalProducer {

    public Animal produce(AnimalFabric fabric) {
        return fabric.create();
    }

}
