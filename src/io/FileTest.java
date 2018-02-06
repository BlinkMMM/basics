package io;

import java.io.File;
import java.io.IOException;

/**
 *  判断文件是否存在，不存在则创建
 */
public class FileTest {
    public static void main(String[] args) throws IOException{
        File file = new File("D:\\hzheng2\\gxy.txt");
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
            file.createNewFile();
        }
        FileTest fileTest = new FileTest();
        fileTest.getClass().getClassLoader().getResource("").getPath();
        System.out.println("A = " + fileTest.getClass().getResource("/").getPath());
        System.out.println("B = " + System.getProperty("user.dir"));
        System.out.println("C = " + file.getAbsolutePath());
        System.out.println("D = " + file.getCanonicalPath());
        System.out.println("E = " + new File("..").getCanonicalPath());
        System.out.println("F = " + System.getProperty("user.home"));
    }
}
