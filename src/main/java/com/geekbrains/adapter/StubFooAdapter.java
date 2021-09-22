package com.geekbrains.adapter;

public class StubFooAdapter implements Foo {

    private Foo foo;

    @Override
    public void f() {
        foo.f();
    }

    @Override
    public void g() {
        foo.g();
    }

    @Override
    public void bar() {
        foo.bar();
    }

    @Override
    public void foo() {
        foo.foo();
    }

}
