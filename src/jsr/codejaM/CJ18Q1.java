package jsr.codejaM;

import java.util.Scanner;

public class CJ18Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int d = in.nextInt();
            char[] str = in.next().toCharArray();
            int dam = getDam(str);
            if(dam<=d){
                System.out.println("Case #" + (i+1) + ": " + "0");
            }
            else{
                int k=str.length-2;
                int l = str.length-1;
                int num = 0;
                while(dam>d && k>=0){
                    if(str[k]=='C'){
                        if(str[k+1]=='S'){
                            num++;
                            str[k]='S';
                            str[k+1]='C';
                            k=str.length-2;
                        }
                    }
                    else{
                        k--;
                    }
                    dam = getDam(str);
                }
                if(dam<=d){
                    System.out.println("Case #" + (i+1) + ": " + num);
                }
                else{
                    System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
                }

            }
        }
    }

    private static int getDam(char[] str) {
        int dam=0;
        int pow = 1;
        for(int j=0; j<str.length; j++){
            if(str[j]=='C'){
                pow *= 2;
            }
            else{
                dam = dam+pow;
            }
        }
        return dam;
    }
}
