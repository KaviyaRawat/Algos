package jsr.codejaM;

import java.util.Scanner;

public class BlandColors {

    public static long blandColors(int n, int k){
       // return ((k+1)*(k+1)*(k+1)*(n+1-k)-k*k*k*(n-k));
        return ((long)(1+3*k+3*k*k)*(long)(n-k+1)+(long)k*k*k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=1; i<=t+1; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println("Case #" + i  + ": " + blandColors(n,k));
        }
    }

}
