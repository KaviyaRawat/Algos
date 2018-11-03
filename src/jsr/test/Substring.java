package jsr.test;

import java.util.Map;

public class Substring {
    public static void main(String[] args) {
        String A = "JSR";
        System.out.println(A.substring(3));
        System.out.println(A.substring(3).equals("")?"JSRJSR":"JSR");
    }
}
