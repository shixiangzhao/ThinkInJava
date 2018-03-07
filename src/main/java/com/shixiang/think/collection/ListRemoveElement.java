package com.shixiang.think.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemoveElement {

    public static void main(String[] args) {

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("张三"));
        pets.add(new Pet("李四"));
        pets.add(new Pet("王五"));
        print(pets);

        Iterator<Pet> it = pets.iterator();
        int index = 0;
        boolean needDelete = true;
        while (it.hasNext()) {
            Pet pet = it.next();
            if (needDelete) {
                //pets.remove(index);//正在遍历的集合，不能进行删除操作ConcurrentModificationException
                //pets.remove(pet);
                it.remove();
                needDelete = false;
            }
        }
        print(pets);
    }

    public static void print(List<Pet> pets) {
        for (Pet p : pets) {
            System.out.println(p);
        }
    }
}
