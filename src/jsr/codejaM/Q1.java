package jsr.codejaM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=1; i<=t; i++){

            int n = in.nextInt();
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            for(int j=0; j<n/2; j++){
                list2.add(j);
                list2.add(j);
            }
            if(n%2==1){
                list2.add((n-1)/2);
            }

            for(int j=0; j<n; j++){
                list1.add(in.nextInt());
            }
            Collections.sort(list1);
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += (list1.get(j)-list2.get(j)) * (list1.get(j)-list2.get(j));
            }
            System.out.println("Case #" + i + ": " + sum);
        }


    }
}
