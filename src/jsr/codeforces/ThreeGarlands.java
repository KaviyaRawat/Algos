package jsr.codeforces;

import java.util.Scanner;

public class ThreeGarlands {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int count = 0;

        if(n==2)
            count++;
        if(a==2)
            count++;
        if(b==2)
            count++;
        if(n==1|| a==1|| b==1)
            count =2;
        if(n==3&&a==3&&b==3)
            count=3;
        System.out.println(count>=2?"YES":"NO");
    }
}

