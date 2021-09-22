package com.geekbrains.adapter;

import java.lang.reflect.Proxy;

public class Sum extends StubFooAdapter {

    @Override
    public void foo() {
        System.out.println("Hello world!");
    }

    @Override
    public void g() {
        System.out.println(1);
        super.g();
        System.out.println(2);

    }


}
