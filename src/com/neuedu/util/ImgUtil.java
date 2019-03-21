package com.neuedu.util;

import javax.servlet.http.Part;
import java.io.*;

public class ImgUtil {
    public static String imgControl(Part part,String servletPath) throws IOException {
        if(part == null){
            return null;
        }
        String oldFileName = part.getSubmittedFileName();
        if(!isImg(oldFileName)){
            return null;
        }
        String newFileName = System.currentTimeMillis()+oldFileName.substring(oldFileName.lastIndexOf("."));
        File path = new File(servletPath);
        if(!path.exists()){
            path.mkdir();
        }
        File newFile = new File(servletPath,newFileName);
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        InputStream inputStream = part.getInputStream();
        OutputStream outputStream = new FileOutputStream(newFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bytes = new byte[1024];
        int len = 0;
        while (-1 != (len = bufferedInputStream.read(bytes))){
            bufferedOutputStream.write(bytes,0,len);
        }
        bufferedOutputStream.flush();
        inputStream.close();
        outputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        return newFileName;
    }
    public static boolean isImg(String fileName){
        if(fileName.indexOf(".")>-1){
            String lastName = fileName.substring(fileName.lastIndexOf("."));
            if(".jpg|.png|.bmp|.webp|.gif".indexOf(lastName) > -1){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
