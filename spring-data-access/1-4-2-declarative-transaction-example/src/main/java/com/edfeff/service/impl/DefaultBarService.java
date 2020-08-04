package com.edfeff.service.impl;

import com.edfeff.model.Foo;
import com.edfeff.service.BarService;

public class DefaultBarService implements BarService {

    @Override
    public Foo getFoo(String fooName) {
        return null;
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        return null;
    }

    @Override
    public void barInsertFoo(Foo foo) {
        System.out.println("foo insert");
        throw new UnsupportedOperationException("form bar unsupported");
    }

    @Override
    public void updateFoo(Foo foo) {

    }
}
