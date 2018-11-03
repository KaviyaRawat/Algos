package jsr.codeforces;

import java.util.Scanner;

public class D496 {

    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        dp = new int[str.length()];
        System.out.println(maxDiv(str, 0, 0));
    }

    public static int maxDiv(String str, int index, int end){
        int count = 0;
        if(end>str.length()-1){
            return 0;
        }
        if(dp[index]!=0){
            return dp[end];
        }
        if(str.charAt(index)=='0'){
            count = 1+maxDiv(str, index+1, index+1);
        }
        else {
            if (new Integer(str.substring(index, end + 1)) % 3 == 0) {
                count = 1 + maxDiv(str, end + 1, end + 1);
            } else {
                count = Math.max(count, maxDiv(str, end + 1, end + 1));
            }


            count = Math.max(count, maxDiv(str, index, end + 1));
        }
        dp[end] = count;
        return count;
    }

}
