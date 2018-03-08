package com.shixiang.think.collection;

import java.util.LinkedList;

public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
        System.out.println(pets);
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.getLast(): " + pets.getLast());
        System.out.println("pets.peek(): " + pets.peek());
        System.out.println(pets);
        System.out.println("pets.remove(): " + pets.remove());
        System.out.println(pets);
        System.out.println("pets.removeFirst(): " + pets.removeFirst());
        System.out.println(pets);
        System.out.println("pets.poll(): " + pets.poll());
        System.out.println(pets);
        pets.addFirst(new Pet("Monkey"));
        System.out.println(pets);
        pets.offer(Pets.randomPet());
        System.out.println(pets);
        pets.add(Pets.randomPet());
        System.out.println(pets);
        pets.addLast(Pets.randomPet());
        System.out.println(pets);
        
    }

}
