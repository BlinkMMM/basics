package io;

import java.io.*;
import java.net.URL;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        FileDemo fileDemo = new FileDemo();
        //System.out.println(fileDemo.readFile01());

        //System.out.println(fileDemo.readFile02());

        //获取分隔符 即 '\'
        String property = System.getProperty("file.separator");
        System.out.println(property);

        //获取相对路径
        System.out.println(fileDemo.getClass().getClassLoader().getResource("resources/demo.txt").getPath());

    }

    String readFile01() throws IOException{
        StringBuffer result = new StringBuffer();
        File file = new File("C:\\Users\\zheng\\Desktop\\demo");
        File[] files = file.listFiles();
        //如果路径没有指定具体到文件（即只到文件夹）则会报无法访问路径的错误，解决：遍历目录demo文件夹下的所有文件，再操作file
        for (File f : files) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null) {
                result.append(line);
                result.append("\n");
                line = br.readLine();
            }
            br.close();
        }
        return result.toString();
    }

    String readFile02() throws IOException{
        StringBuffer result = new StringBuffer();
        //绝对路径
        File file = new File("D:\\myProject\\basics\\src\\resources\\demo.txt");
        File file1 = new File("resources/demo.txt");
        //获取相对路径
        URL resource = this.getClass().getClassLoader().getResource("resources/demo.txt");
        File file2 = new File(resource.getPath());

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file2), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while(line!=null){
            result.append(line);
            result.append("\n");
            line = br.readLine();
        }
        br.close();
        return result.toString();
    }
}
