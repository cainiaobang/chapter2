package org.smart4j.chapter2.test;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.Enumeration;

public class DailyTest {
    @Test
    public void test1(){
        String  packagePath="/C:/Users/Administrator/IdeaProjects/chapter2/target/test-classes/org/smart4j/chapter2/test";
        File[] files=new File(packagePath).listFiles(new FileFilter(){
            public boolean accept(File file){
                return (file.isFile()&& file.getName().endsWith(".class"))||file.isDirectory();
            }
        });
        for(File file:files){
            System.out.println(file);
        }
    }

    @Test
    public void test2() throws Exception{
        String  packagePath="";
        Enumeration<URL> urls=getClassLoader().getResources(packagePath.replace(".","/"));

        while(urls.hasMoreElements()){
            URL url=urls.nextElement();
            if (url != null) {
                String protocal = url.getProtocol();
                if (protocal.equals("file")) {
                    String packagePath1 = url.getPath().replaceAll("%20", "");
                    System.out.println(packagePath1);
                }
            }
            System.out.println(url);
        }
    }

    public static ClassLoader getClassLoader(){
        return  Thread.currentThread().getContextClassLoader();
    }
}
