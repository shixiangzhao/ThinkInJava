package com.shixiang.think.collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingLists {

    public static void main(String[] args) {
        //cCopies(),copy对象引用
        List<StringAddress> list = new ArrayList<StringAddress>(
                Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        //Replaces all of the elements of the specified list with the specified element
        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}

class StringAddress {

    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    public String toString() {
        return super.toString() + " " + s;
    }
}
