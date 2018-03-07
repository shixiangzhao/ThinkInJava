package com.shixiang.think.collection;

public class Pet {
    private String name;
    
    public Pet(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - " + name;
    }
}
