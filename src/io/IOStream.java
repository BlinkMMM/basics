package io;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.net.URL;

public class IOStream {
    public static void main(String[] args) {
        IOStream io = new IOStream();
        URL resource = io.getClass().getClassLoader().getResource("resources/test.txt");
        File file = new File(resource.getFile());
        io.readFile(file);

        URL imgResource = io.getClass().getClassLoader().getResource("resources/test.png");
        File img = new File(imgResource.getFile());
        try {
            FileImageInputStream fileImageInputStream = new FileImageInputStream(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void readFile(File file){
        try {
            FileReader fr = new FileReader(file);
            int read = 0;
            while ((read = fr.read()) != -1){
                System.out.print((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readStream(InputStream inputStream){
        try {
            int read = 0;
            while((read = inputStream.read())!=-1){
                System.out.println((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
