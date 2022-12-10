package com.demo;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        System.out.println("start analysis photo.........");
        File file = new File("D:\\Users\\Administrator\\Desktop\\IMG_5225.jpeg");
        Metadata metadata; //元数据


        try {
            metadata = JpegMetadataReader.readMetadata(file);   //图片数据读取器读取图片二进制数据

            Iterator<Directory> iterator = metadata.getDirectories().iterator(); //获取数据条数迭代器
            while (iterator.hasNext()) {
                Directory next = iterator.next();
                Iterator<Tag> iterator1 = next.getTags().iterator();
                while (iterator1.hasNext()) {
                   Tag tag =  (Tag)iterator1.next();
                    System.out.println(tag);
                }
            }

            System.out.println("photo analysis end...");
        } catch (JpegProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
