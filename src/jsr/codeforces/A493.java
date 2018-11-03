package jsr.codeforces;

import java.util.Scanner;

public class A493 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] balloons = new int[N];
        for(int i=0; i<N; i++){
            balloons[i] = in.nextInt();
        }

        if(N==1 || N==0)
            System.out.println(-1);
        else if(N==2 && balloons[0]==balloons[1])
            System.out.println(-1);
        else{
            int count = 1;
            int gCount = balloons[0];
            int[] ans = {1};
            int aCount = 0;
            for(int i=1; i<N; i++){
                aCount += balloons[i];
            }
            if(gCount==aCount){
                count =2;
                ans = new int[]{1, 2};
            }
            System.out.println(count);
            for(int i=0; i<ans.length - 1; i++){
                System.out.print(ans[i] + " ");

            }
            System.out.print(ans[ans.length-1]);
        }
    }



}
