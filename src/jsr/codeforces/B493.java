package jsr.codeforces;

import java.util.Scanner;

public class B493 {

    static int[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B = in.nextInt();
        int[] balloons = new int[N];
        for(int i=0; i<N; i++){
            balloons[i] = in.nextInt();
        }
        dp = new int[N][B+1];
        System.out.println(optimalNum(balloons, B, 0));
    }

    private static int optimalNum(int[] balloons, int b, int index) {
        int even = 0;
        int odd = 0;
        int ans = 0;
        if(index== balloons.length){
            return 0;
        }
        if(dp[index][b] == 0) {
            for (int i = index; i < balloons.length; i++) {
                if (balloons[i] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
                if (even == odd && i < balloons.length - 1) {
                    if (Math.abs(balloons[i] - balloons[i + 1]) <= b) {
                        ans = Math.max(ans, 1 + optimalNum(balloons,
                                b - Math.abs(balloons[i] - balloons[i + 1]),
                                i + 1));
                    }
                }
            }
            dp[index][b] = ans;
        }

        return dp[index][b];

    }

}
