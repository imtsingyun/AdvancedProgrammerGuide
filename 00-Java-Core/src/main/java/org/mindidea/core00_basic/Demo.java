package org.mindidea.core00_basic;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * 2020/11/14 23:31
 * https://mindidea.org
 */
public class Demo {
   public static void main(String[] args) {
       System.out.println("Hello World");

       String a = null;
       Objects.requireNonNull(a);

       System.out.println(a.length());


   } 
}
