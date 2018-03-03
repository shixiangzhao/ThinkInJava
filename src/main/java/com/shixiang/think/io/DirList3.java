package com.shixiang.think.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList3 {

    public static void main(final String[] args) {
        File path = new File("./src/com/shixiang/io");
        String[] liStrings;
        if (args.length == 0) {
            liStrings = path.list();
        } else {
            liStrings = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });// End of anonymous inner class
        }
        for (String dirItem : liStrings) {
            System.out.println(dirItem);
        }
    }
}
