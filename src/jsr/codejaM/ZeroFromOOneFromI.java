package jsr.codejaM;

import java.util.Scanner;

public class ZeroFromOOneFromI {

    public static char byteToChar(String str, int index){
        int val = 0;
        int num = 128;

        for(int i =0; i<8; i++){
            int oneZero;
            if(str.charAt(i+index)=='I'){
                oneZero = 1;
            }
            else{
                oneZero = 0;
            }
            val += oneZero * num ;
            num = num/2;
        }

        if(val==32){
            return ' ';
        }

        return (char) val;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=1; i<t+1; i++){
            int n = in.nextInt();
            String input = in.next();
            StringBuilder str = new StringBuilder();
            for(int j=0; j<input.length();j=j+8){
                str.append(byteToChar(input, j));
            }
            System.out.println("Case #" + i  + ": " + str);
        }

    }
}
