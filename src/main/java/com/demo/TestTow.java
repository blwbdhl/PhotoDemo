package com.demo;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;

import java.io.File;
import java.io.IOException;

public class TestTow {
    public static void main(String[] args) {
        System.out.println("start analysis photo.........");
        File file = new File("D:\\Users\\Administrator\\Desktop\\IMG_20221210_011854.jpg");
        Metadata metadata; //元数据

        try {
            metadata = JpegMetadataReader.readMetadata(file);   //图片数据读取器读取图片二进制数据
            Iterable<Directory> directories = metadata.getDirectories();
            System.out.println(directories.toString());


        } catch (JpegProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
