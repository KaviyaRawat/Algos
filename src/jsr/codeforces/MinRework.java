package jsr.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinRework {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<N; i++){
            int num = in.nextInt();
            list.add(num);
            sum += num;
        }
        double min = 4.5*N;
        if(sum<min){
            Collections.sort(list);
            double diff = min-sum;
            int count=0;
            int j=0;
            while(j>=0 && diff>0){
                diff -= (5-list.get(j));
                j++;
                count++;
            }
            if(diff>0)
                System.out.println(-1);
            else
                System.out.println(count);
        }
         else
            System.out.println(0);

    }

}
