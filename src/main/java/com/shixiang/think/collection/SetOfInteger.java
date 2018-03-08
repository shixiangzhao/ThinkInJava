package com.shixiang.think.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetOfInteger {

    public static void main(String[] args) {
        Random rand = new Random(47);
        //不保存重复元素，散列函数
        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 60; i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }

}
