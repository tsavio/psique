package com.example.psique_mobile.com.google;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class UtilsGoogle {
    public static boolean isNullorEmpty(String imgPath) {
        return imgPath != null && imgPath.length() != 0;
    }

    public static void copyFile(String source, String dest) {
//        FileChannel sourceChannel = null;
//        FileChannel destChannel = null;
//        try {
//            sourceChannel = new FileInputStream(source).getChannel();
//            destChannel = new FileOutputStream(dest).getChannel();
//            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
//        }finally{
//            sourceChannel.close();
//            destChannel.close();
//        }
    }
}
