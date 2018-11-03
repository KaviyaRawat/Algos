package jsr.codeforces;

import java.util.Scanner;

public class HowManyDintPass {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int N = in.nextInt();
        if(C>A || C>B || (A+B-C)>=N )
            System.out.println(-1);
        else
            System.out.println(N-(A+B-C));

    }
}
