package jsr.interviewBit;

public class AlphabetNumDecodeCode {


    public static class Solution {
        int[] dpStore;
        public int numDecodings(String A) {
            if(A==null || A.length()==0){
                return 0;
            }

            dpStore = new int[A.length()];
            char nm = A.charAt(0);
            if(nm==0){
                return 0;
            }
            for(int i=1; i<A.length(); i++){
                if(A.charAt(i)==0){
                    if(nm!=1 && nm!=2){
                        return 0;
                    }
                    nm = A.charAt(i);
                }
            }

            return numDecodings(A,0);

        }

        public int numDecodings(String A, int index){
            if(index<A.length() && A.charAt(index)=='0'){
                return 0;
            }
            if(A==null || index>=A.length()){
                return 1;
            }

            if(dpStore[index]==0){
                if(A.charAt(index)=='1' && index+1<A.length()){
                    dpStore[index] = dpStore[index] + numDecodings(A, index+2);
                }
                if(A.charAt(index)=='2' && index+1<A.length() && A.charAt(index+1)<55){
                    dpStore[index] = dpStore[index] + numDecodings(A, index+2);
                }
                //if(index+1<A.length() && A.charAt(index)!=0){
                dpStore[index] = dpStore[index] + numDecodings(A, index+1);
                //}

            }
            return dpStore[index];

        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("11027"));
    }

}
