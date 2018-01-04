package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDemo {
    public static void main(String[] args) throws IOException{
        File file = new File("C:\\Users\\zheng\\Desktop\\demo");
        File[] files = file.listFiles();
        for (File f:files) {
            System.out.println(f);
            InputStream inputStream = new FileInputStream(f);

        }
    }
}
