package com.edfeff.service;

import com.edfeff.model.Foo;

public interface BarService {
    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void barInsertFoo(Foo foo);

    void updateFoo(Foo foo);
}
