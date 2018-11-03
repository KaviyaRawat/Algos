package jsr.codeforces;

import java.util.Scanner;

public class B496 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        int i = A.length()-1;
        int j = B.length()-1;
        while(i>=0 && j>=0 && A.charAt(i)==B.charAt(j)){
            i--;
            j--;
        }
        System.out.println(i+j+2);
    }

}
