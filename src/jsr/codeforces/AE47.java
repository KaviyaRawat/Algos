package jsr.codeforces;

import java.util.Scanner;

public class AE47 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] arr1= new int[N];
        int[] arr2= new int[M];
        for(int i=0; i<N; i++){
            arr1[i] = in.nextInt();

        }
        for(int i=0; i<M; i++){
            arr2[i] = in.nextInt();

        }
        int i=0;
        int j=0;
        int count = 0;
        while(i<=N-1 && j<=M-1){
            if(arr1[i]<=arr2[j]){
                j++;
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}
