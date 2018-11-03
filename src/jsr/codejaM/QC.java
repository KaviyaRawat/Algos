package jsr.codejaM;

import java.util.Scanner;

public class QC {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String a;
        String b;
        String c;
            for(int i = 1; i<=t; i++){
                int n = in.nextInt();
                a= in.next();
                b= in.next();
                c= in.next();
                int j=0;
                while(j<n && a.charAt(j) == b.charAt(j) && a.charAt(j) == c.charAt(j)){
                    j++;
                }
                if(j==n){
                    System.out.println("Case #" + i + ": " + "NO NO NO");
                }
                if(a.charAt(j)!=b.charAt(j) && b.charAt(j)!=c.charAt(j) && c.charAt(j)!=a.charAt(j)){
                    System.out.println("Case #" + i + ": " + "YES YES YES");
                }
                else{
                    if(a.charAt(j)==b.charAt(j)){
                        char ch = c.charAt(j);
                        char ch2 = a.charAt(j);
                        while(j<n && a.charAt(j)==b.charAt(j)){
                            j++;
                        }
                        if(a.charAt(j)==ch && b.charAt(j)==ch2){
                            System.out.println("Case #" + i + ": " + "YES NO NO");
                        }
                        else if(b.charAt(j)==ch && a.charAt(j)==ch2){
                            System.out.println("Case #" + i + ": " + "NO YES NO");
                        }
                        else{
                            System.out.println("Case #" + i + ": " + "YES YES NO");
                        }

                    }
                    else if(a.charAt(j)==c.charAt(j)){
                        char ch = b.charAt(j);
                        char ch2 = c.charAt(j);
                        while(j<n && a.charAt(j)==c.charAt(j)){
                            j++;
                        }
                        if(a.charAt(j)==ch && c.charAt(j)==ch2){
                            System.out.println("Case #" + i + ": " + "YES NO NO");
                        }
                        else if(c.charAt(j)==ch && a.charAt(j)==ch2){
                            System.out.println("Case #" + i + ": " + "NO NO YES");
                        }
                        else{
                            System.out.println("Case #" + i + ": " + "YES NO YES");
                        }

                    }
                    else{
                        char ch = a.charAt(j);
                        char ch2 = b.charAt(j);
                        while(j<n && b.charAt(j)==c.charAt(j)){
                            j++;
                        }
                        if(b.charAt(j)==ch && c.charAt(j)==ch2){
                            System.out.println("Case #" + i + ": " + "NO YES NO");
                        }
                        else if(c.charAt(j)==ch && b.charAt(j)==ch2){
                            System.out.println("Case #" + i + ": " + "NO NO YES");
                        }
                        else{
                            System.out.println("Case #" + i + ": " + "NO YES YES");
                        }
                    }
                }
            }
    }


}
