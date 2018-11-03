package jsr.codeforces;

import java.util.Scanner;

public class Bishwock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        int count = 0;
        int i=0;
        int N = A.length();
        while(i<A.length()){

             if(N-i>1){
                 int whites = twoWhite(A, B, i);
                 if(whites==4){
                     if(N-i>2 && oneWhite(A, B, i+2)){
                         count = count+2;
                         i=i+3;
                     }
                     else {
                         count = count+1;
                         i = i + 2;
                     }
                 }
                 else if(whites==3){
                     count++;
                     i=i+2;
                 }
                 else{
                     i=i+1;
                 }

             }
             else{
                 i++;
             }

        }
        System.out.println(count);

    }

    private static boolean oneWhite(String a, String b, int i) {
        if(a.charAt(i)==b.charAt(i) && a.charAt(i)=='0')
            return true;
        return false;
    }

    private static int twoWhite(String a, String b, int i) {
        int count = 0;
        if(a.charAt(i)=='0'){
            count++;
        }
        if(b.charAt(i)=='0'){
            count++;
        }
        if(b.charAt(i+1)=='0'){
            count++;
        }
        if(a.charAt(i+1)=='0'){
            count++;
        }
        return count;
    }
}
