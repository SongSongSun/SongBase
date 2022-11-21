package com.song.base;

public class BaseEntityTest extends BaseEntity<String> {

    @Override
    protected void doExecute(String s) {
        System.out.println("hello " + s);
    }

    public static void main(String[] args) {
        BaseEntityTest test = new BaseEntityTest();
        test.execute("world");
    }
}
