package org.smart4j.chapter2.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Set;

public class Test3 {

    private static final Logger LOGGER= LoggerFactory.getLogger(Test3.class);

    private static void addClass(Set<Class<?>> classSet, String  packagePath, String packageName){
        File[] files=new File(packagePath).listFiles(new FileFilter(){
            public boolean accept(File file){
                return (file.isFile()&& file.getName().endsWith(".java"))||file.isDirectory();
            }
        });
        for(File file:files){
            String fileName=file.getName();
            if(file.isFile()){
                String className = fileName.substring(0,fileName.lastIndexOf("."));
                if(StringUtil.isNotEmpty(packageName)){
                    className=packageName+"."+className;
                }
                doAddClass(classSet,className);
            }else{
                String subPackagePath=fileName;
                if(StringUtil.isNotEmpty(packagePath)){
                    subPackagePath=packagePath+"/"+subPackagePath;
                }
                String subPackageName=fileName;
                if(StringUtil.isNotEmpty(packageName)){
                    subPackageName=packageName+"."+subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }

        }
    }

    public static void doAddClass(Set<Class<?>> classSet,String className) {
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }

    public static ClassLoader getClassLoader(){
        return  Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className,boolean isInitialized){
        Class<?> cls;
        try{
            cls=Class.forName(className,isInitialized,getClassLoader());
        }catch(ClassNotFoundException e){
            LOGGER.error("load class failure",e);
            throw new RuntimeException(e);
        }
        return cls;
    }

    @Test
    public void test() throws Exception{
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        String  packagePath="C:\\Users\\Administrator\\IdeaProjects\\chapter2\\src\\main\\java";
        String  packageName="";
        addClass(classSet,packagePath,packageName);
        System.out.println(classSet);
    }

}


class StringUtil {

    public static boolean isEmpty(String str){
        if(str!=null){
            str=str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}


