package com.geekbrains;

import java.util.Arrays;

public class HelloWorld {

    private int[] arr;

    public HelloWorld() {
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000000);
        }

        User user = User.builder()
                .name("Ivan")
                .surname("Ivanov")
                .birthDate("23.06.1990")
                .build();

        User user1 = new UserBuilder()
                .setName("Ivan")
                .setSurname("Ivanov")
                .build();
    }

    public int foo() {
        //
        return 1;
    }

    public int badFoo(int x) {
        return x / 0;
    }

    public int sum(int a, int b) {
        return a + b;
    }


    public int[] longFoo() {
        Arrays.sort(arr);
        return arr;
    }
}
