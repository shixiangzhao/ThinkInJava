package com.shixiang.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };// End of anonymous inner class
    }

    public static void main(String[] args) {
        File path = new File("./src/com/shixiang/io");
        String[] liStrings;
        if (args.length == 0) {
            liStrings = path.list();
        } else {
            liStrings = path.list(filter(args[0]));
        }
        for (String dirItem : liStrings) {
            System.out.println(dirItem);
        }
    }
}
