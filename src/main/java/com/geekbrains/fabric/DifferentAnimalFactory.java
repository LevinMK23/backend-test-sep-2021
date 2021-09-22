package com.geekbrains.fabric;

public class DifferentAnimalFactory {

    public static Cat getCat() {
        return new Cat();
    }

    public static Dog getDog() {
        return new Dog();
    }
}
