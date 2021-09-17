package com.geekbrains;

import java.util.Arrays;

public class HelloWorld {

    private int[] arr;

    public HelloWorld() {
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000000);
        }
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
