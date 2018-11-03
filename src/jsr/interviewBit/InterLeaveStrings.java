package jsr.interviewBit;

public class InterLeaveStrings
{


    public static class Solution {
        int[][] dp;
        public int isInterleave(String A, String B, String C) {
            dp = new int[C.length()][2];
            return call(A, B, C);


        }

        public int call(String A, String B, String C) {
            if(C.length()!=A.length()+B.length()){
                return 0;
            }

            if(dp[C.length()-1][0]==0){
                dp[C.length()-1] = new int[2];
                if(A.length()==0){
                    if(B.equals(C)){
                        dp[C.length()-1][1] = 1;
                        return 1;
                    }
                    else
                        dp[C.length()-1][1] = -1;
                    return 0;
                }

                if(B.length()==0){
                    if(A.equals(C)){
                        dp[C.length()-1][0] = 1;
                        return 1;
                    }
                    else{
                        dp[C.length()-1][0] = -1;
                        return 0;
                    }
                }

                if(A.charAt(0)==C.charAt(0)){
                    if(A.length()==1){
                        if(call("", B, C.substring(1))==1)
                            dp[C.length()-1][0] = 1;
                        else
                            dp[C.length()-1][0] = -1;
                    }
                    else{
                        if(call(A.substring(1), B, C.substring(1))==1)
                            dp[C.length()-1][0] = 1;
                        else
                            dp[C.length()-1][0] = -1;
                    }
                }
                if(B.charAt(0)==C.charAt(0)){
                    if(B.length()==1){
                        if(call(A, "", C.substring(1))==1){
                            dp[C.length()-1][1] = 1;
                        }
                        else
                            dp[C.length()-1][1] = -1;
                    }
                    else{
                        if(call(A,B.substring(1), C.substring(1))==1){
                            dp[C.length()-1][1] = 1;
                        }else
                            dp[C.length()-1][1] = -1;
                    }
                }
            }
            if(dp[C.length()-1][0]==1 || dp[C.length()-1][1]==1)
                return 1;
            else
                return 0;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("Z", "8GUKOk8Dm8LRdq9jIqKSNF1SCAppV0gCUxAACAF43R5F6W", "8GUZKOk8Dm8LRdq9jIqKSNF1SCAppV0gCUxAACAF43R5F6W"));
    }


}
