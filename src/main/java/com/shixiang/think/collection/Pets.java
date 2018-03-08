package com.shixiang.think.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pets {

    public static List<Pet> arrayList(int count) {
        List<Pet> pets = new ArrayList<Pet>();
        for (int j = 0; j < count; j++) {
            pets.add(new Pet("dog" + j));
        }
        return pets;
    }

    public static Pet randomPet() {
        Pet[] pets = {
                new Pet("Cat"), new Pet("Dog"), new Pet("Monkey")
        };
        Random r = new Random();
        int i = r.nextInt(3);
        return pets[i];
    }

    public static void main(String[] args) {
        Random r = new Random();
        int i = r.nextInt(3);
        System.out.println(i);
    }

}
