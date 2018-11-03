package jsr.codeforces;

import java.util.Scanner;

public class ClosestMinimum {


    public static void main(String[] args) {
        int[] array;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        array = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            array[i] = in.nextInt();
            if(array[i]<min)
                min = array[i];
        }
        int distance;
        int prevMin;
        int i =0;
        while(array[i]!=min)
            i++;
        prevMin = i++;
        while(array[i]!=min)
            i++;
        distance = i-prevMin;
        prevMin = i;
        for(i=i+1;i<n; i++){
            if(array[i]==min){
                distance = Math.min(distance, i-prevMin);
                prevMin=i;
            }
        }
        System.out.println(distance);
    }

}
