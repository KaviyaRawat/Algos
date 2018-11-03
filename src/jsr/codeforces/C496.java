//package jsr.codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class C496 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>();
        int[] array = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int M = in.nextInt();
            array[i] = M;
            if(arr.get(M)==null){
                arr.put(M, 0);
            }
            arr.put(M, arr.get(M)+1);
            max = Math.max(M, max);
        }
        int[] array2 = new int[32];
        array2[0] = 1;

        for(int i=1; i<32; i++){
            array2[i] = array2[i-1]*2;
        }
        int count = 0;
        for(int i=0; i<N; i++){
            if(!isAvailable(array2, arr, array[i])){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isAvailable(int[] array2, HashMap<Integer, Integer> arr, int i) {
        for(int j=0; j<32; j++){
            if(array2[j]<i){

            }
            else{
                if(array2[j]-i==i){
                    if(arr.get(i)>1){
                        return true;
                    }
                }
                else{
                    if(arr.get(array2[j]-i)!=null){
                        return true;
                    }
                }
            }
        }
        return false;

    }


}
