package jsr.test;

import java.util.HashMap;

public class HashMapTest {


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("JSR", 1);
        map.put("abc", null);
        map.put(null, null);
        map.remove("def");
        map.remove("abc");
        System.out.println(map);
    }
}
