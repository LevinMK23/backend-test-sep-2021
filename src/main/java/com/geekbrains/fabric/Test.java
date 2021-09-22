package com.geekbrains.fabric;

import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

        new AnimalProducer()
                .produce(new DogFabric())
                .say();

        Cat cat = DifferentAnimalFactory.getCat();
        Dog dog = DifferentAnimalFactory.getDog();

        ExecutorService service = Executors.newFixedThreadPool(4);



    }
}
