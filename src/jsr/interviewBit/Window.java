package jsr.interviewBit;

import java.util.HashMap;
import java.util.Map;

public class Window {

        public String minWindow(String A, String B) {

            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<B.length(); i++){
                if(map.get(B.charAt(i))==null){
                    map.put(B.charAt(i), 1);
                }
                else {
                    map.put(B.charAt(i), map.get(B.charAt(i)) + 1);
                }
            }

            int start=0;

            int minLength = Integer.MAX_VALUE;
            int startMin = start;

            for(int i=0; i<A.length(); i++){
                if(map.get(A.charAt(i))!=null) {
                    map.put(A.charAt(i), map.get(A.charAt(i)) - 1);

                    while (covers(map)) {
                        if (minLength > i - start + 1) {
                            startMin = start;
                            minLength = i - start + 1;
                        }
                        while (map.get(A.charAt(start)) == null) {
                            start++;
                        }
                        if (minLength > i - start + 1) {
                            startMin = start;
                            minLength = i - start + 1;
                        }
                        if (map.get(A.charAt(start)) <= 0) {
                            map.put(A.charAt(start), map.get(A.charAt(start)) + 1);
                            start++;
                        }
                    }


                }
            }

            if(minLength==Integer.MAX_VALUE){
                return "";
            }

            return A.substring(startMin, minLength+startMin);
        }

    private boolean covers(HashMap<Character, Integer> map) {
            for(Map.Entry<Character, Integer> e: map.entrySet()) {
                if (e.getValue() > 0) {
                    return false;
                }
            }
            return true;
    }

    public static void main(String[] args) {
        System.out.println(new Window().minWindow("ADOBECODEBANC", "ABC"));
    }

}
