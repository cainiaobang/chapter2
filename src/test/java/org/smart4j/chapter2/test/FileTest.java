package org.smart4j.chapter2.test;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class FileTest {

    public static void main(String[] args){
        File file;
        try{
            file=new File("d:/tmp2/upload/002.txt");
            System.out.println(file.getPath());
            File parentDir=file.getParentFile();
            if(!parentDir.exists()){
                FileUtils.forceMkdir(parentDir);
            }
        }catch(Exception e){
            System.out.println("error");
            throw new RuntimeException(e);
        }
    }
}
