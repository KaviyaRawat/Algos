package jsr.zeta;

import java.util.HashMap;

public class CollatsLengthCalculator {

    static HashMap<Long, Long> map = new HashMap<>();

    public static long maxCollat(int x){
        long max = 0;
        for(int i=1; i<=x; i++) {
            max = Math.max(max, collatLength(i));
        }
        return max;
    }

    public static long collatLength(long x){

        long num = x;
        long count = 0;
        if(x==1){
            return 0;
        }
            if(map.get(num)!=null){
                return map.get(num);
            }

            if(num%2==0){
                count = 1+ collatLength(num/2);
            }
            else{
                count = 1+ collatLength(3*num+1);
            }
            map.put(num, count);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(CollatsLengthCalculator.maxCollat(10000000));
    }

}
