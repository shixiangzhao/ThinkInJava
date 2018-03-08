package com.shixiang.think.collection;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> listIterator = pets.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(
                    listIterator.next() + ", " + listIterator.nextIndex() + ", " + listIterator.previousIndex());
        }
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous().getName());
        }
        System.out.println(pets);
        //从第index个元素向后所有元素
        listIterator = pets.listIterator(2);
        while(listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(Pets.randomPet());
        }
        System.out.println(pets);
    }

}
