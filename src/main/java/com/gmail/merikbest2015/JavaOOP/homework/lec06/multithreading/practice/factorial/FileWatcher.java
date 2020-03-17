package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.factorial;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileWatcher implements Runnable {
    private File mainFolder;

    public FileWatcher(File mainFolder) {
        this.mainFolder = mainFolder;
    }

    public FileWatcher() {
    }

    public File getMainFolder() {
        return mainFolder;
    }

    public String getFolderInt() {
        if (mainFolder == null) {
            return "None";
        }
        StringBuilder builder = new StringBuilder();
        File[] filesArray = this.mainFolder.listFiles();
        for (File file : filesArray) {
            builder.append(file + "\t" + file.length()).append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");
        while (!thread.isInterrupted()) {
            System.out.println(sdf.format(System.currentTimeMillis()));
            System.out.println(getFolderInt());
            System.out.println();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("File watcher is stop!!!");
    }
}