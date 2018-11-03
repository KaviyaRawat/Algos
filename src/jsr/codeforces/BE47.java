package jsr.codeforces;

import java.util.Scanner;
import java.util.TreeMap;

public class BE47 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] array = new int[str.length()];
        int[] count = {0};
        int i=0;
        while(i<str.length()){
            TreeMap<Character, Integer> map = new TreeMap<>();
            while(i<str.length()){
                if(str.charAt(i)=='0' && map.containsKey('2')){
                    break;
                }
                if(str.charAt(i)=='2' && map.containsKey('0')){
                    break;
                }
                if(map.get(str.charAt(i))==null){
                    if(map.size()==2){
                        break;
                    }else{
                        map.put(str.charAt(i), 0);
                    }
                }
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
                i++;
            }
            map.forEach((key, value) ->{
                while(value>0) {
                    array[count[0]++] = key;
                    value--;
                }
            });

        }
        for(i=0; i<array.length; i++){
            System.out.print(array[i]-48);
        }

    }

}
