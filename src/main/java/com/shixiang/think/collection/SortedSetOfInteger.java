package com.shixiang.think.collection;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SortedSetOfInteger {

    public static void main(String[] args) {
        Random rand = new Random(47);
        //不保存重复元素，红黑树
        Set<Integer> intset = new TreeSet<Integer>();
        for (int i = 0; i < 60; i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }

}
