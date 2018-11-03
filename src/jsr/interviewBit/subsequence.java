package jsr.interviewBit;

public class subsequence {
    public static class Solution {
        public int numDistinct(String A, String B) {

            if(A.equals(B)){
                return 1;
            }
            if(B.equals("") || A.equals("")){
                return 0;
            }
            if(A.length()<B.length()){
                return 0;
            }
            int count = 0;
            int i=0;
            while(i<A.length() && A.charAt(i)!=B.charAt(0)){
                i++;
            }
            if(i==A.length()){
                return 0;
            }
            count  =  count  +  numDistinct(A.substring(i+1), B.substring(1)) + numDistinct(A.substring(i+1), B);

            return count;

        }



    /*public boolean check(String A, String B){
        int i=0; int j=0;
        while(i<A.length() && j<B.length()){
            while(A.charAt(i)=='_'){
                i++;
            }
            if(A.charAt(i)!=B.charAt(j)){
                return false;
            }
            i++;
            j++;
        }
        if(j<B.length())
            return false;
        while(A.length()>i){
            if(A.charAt(i)!='_'){
                return false;
            }
        }
        return true;
    }*/
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("babba", "ab"));
    }
}
