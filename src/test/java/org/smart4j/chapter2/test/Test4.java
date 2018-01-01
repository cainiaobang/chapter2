package org.smart4j.chapter2.test;


import org.junit.Test;

import java.lang.annotation.Annotation;


@Aspect(Controller.class)
class Test2{
}
public class Test4 {
    @Test
    public  void test(){
        Aspect aspect=Test2.class.getAnnotation(Aspect.class);
        Class<? extends Annotation> annotation=aspect.value();
        System.out.println(annotation);
    }
}


