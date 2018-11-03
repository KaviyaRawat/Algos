package jsr.gfg;

import java.util.Scanner;

public class LIS {
    private static int[] dpStore;

    public static  int LIS(int[] arr, int index, int lastElement){
        if(index == arr.length){
            return 0;
        }

        if(lastElement<= arr[index]){
            if(dpStore[index]==0){
                dpStore[index] = 1+LIS(arr, index+1, arr[index]);
            }


            return Math.max(dpStore[index], LIS(arr, index+1, lastElement));
        }
        else{

                return LIS(arr, index+1, lastElement);

        }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(int i=0; i<T; i++){
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int j=0; j<N; j++){
                arr[j] = in.nextInt();

            }
            dpStore = new int[N];
            System.out.println(LIS(arr, 0, Integer.MIN_VALUE));
        }
        //code
    }
}
