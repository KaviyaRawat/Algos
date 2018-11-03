package jsr.codeforces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class C493 {

    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        dp = new int[N+1];
        String str = in.next();
        System.out.println(optimumCount(str, 0, X, Y));

    }

    private static int optimumCount(String str, int i1, int x, int y) {
        int ans = Integer.MAX_VALUE;
        if(dp[i1]!=0)
            return dp[i1];

        int temp = i1;
        if(i1>=str.length())
            return 0;

        while(i1<str.length() && str.charAt(i1)=='1'){
            i1++;
        }
        if(i1==str.length())
            return 0;
        int start = i1;
        while(i1<str.length() && str.charAt(i1)=='0'){
            i1++;
        }

        int end = i1-1;
        ans = Math.min(ans, y+optimumCount(str, end+1, x, y));
        if(i1!=str.length()) {
            int count = 0;
            while (i1 < str.length() && str.charAt(i1) == '1') {
                i1++;
                count++;
            }
            String str2;
            if (i1 < str.length() - 1)
                str2 = str.substring(0, start) + str.substring(end + 1, i1) + str.substring(start, end + 1) + str.substring(i1 + 1);
            else
                str2 = str.substring(0, start) + str.substring(end + 1, i1) + str.substring(start, end + 1);
            ans = Math.min(ans, x + optimumCount(str2, temp + count, x, y));
        }


        return ans;

    }


}




