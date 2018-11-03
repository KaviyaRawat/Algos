package jsr.test;

import java.util.HashMap;
import java.util.Map;

public class StreamMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "linode.com");
        map.put(2, "heroku.com");
        map.entrySet().stream().forEach(x->x.setValue(x.getValue()));
    }
}
