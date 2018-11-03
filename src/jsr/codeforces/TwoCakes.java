package jsr.codeforces;

import java.util.Scanner;

public class TwoCakes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        /*for(int i=1; i<=a;i++){
            min = Math.min(min, i);
            int unserved;
            if(a%i==0){
                unserved = n-a/i;
            }else{
                min= Math.min( a%i, min);
                unserved = n -(a/i + 1);
            }
            int nextPortion = b/unserved;
            min = Math.min(min, nextPortion);
            max = Math.max(max, min);
        }*/
        int each = n/(a+b);
        int minA = a%each==0?each:(a%each);

        int[] unserved = {(n-a/each), (n-a/each+1)/*, (n-a/each-1)*/};
        for(int j=0; j<unserved.length; j++){
            int minB = b%unserved[j]==0?each:(b%each);
            if(unserved[j] == n-a/each){
                min = Math.min(each, minB);
            }
            if(unserved[j] == n-a/each+1){
                min = Math.min(minB, min);
                min =Math.min(min, a%each);
            }
        }

    }
}
