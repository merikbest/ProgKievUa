package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.practice.fileoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {

    public static void fileCopy(File in, File out) throws IOException {


        byte[] buffer = new byte[1024 * 1024];
        int readByte = 0;
        try (FileInputStream fileInputStream = new FileInputStream(in);
             FileOutputStream fileOutputStream = new FileOutputStream(out)) {

            while ((readByte = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, readByte);
            }


        } catch (IOException e) {
            throw e;
        }
    }

    public static long calculateFolderSizeOne(File folder) {
//        File folder = new File(".");
        File[] filesArray = folder.listFiles();

        long fileSize = 0;
        for (File file1 : filesArray) {
            fileSize += file1.length();
        }
        return fileSize;
    }

    public static long calculateFolderSizeTwo(File folder) {
        if (folder.isFile()) {
            return folder.length();
        } else {
            long size = 0;
            File[] fileArray = folder.listFiles();
            for (File file : fileArray) {
                size += calculateFolderSizeTwo(file);
            }
            return size;
        }
    }
}