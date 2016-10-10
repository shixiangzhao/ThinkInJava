package com.shixiang.io;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        File path = new File("./src/com/shixiang/io");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
