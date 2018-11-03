package jsr.interviewBit;

public class MaxHeapsNMinus1 {
        int dpStore[][];
        public int solve(int[] A) {

            int num;
            int max = A[0];
            for(int i=1; i<A.length; i++){
                if(A[i]>max){
                    max = A[i];
                }
            }
            int maxCount = 0;
            for(int i=0; i<A.length; i++){
                if(A[i]== max){
                    maxCount++;
                }
            }
            boolean maxTwice = false;
            if(maxCount>1){
                maxTwice = true;
            }


            if(A.length == 1){
                return 1;
            }


            dpStore = new int[A.length][A.length];

            for(int i=0; i<A.length; i++){
                for(int j=0; j<A.length; j++){
                    dpStore[i][j] = -1;
                }
            }
            int leftCount = calculateLN(A.length);
            if(maxTwice){
                num = nCk(A.length-1, leftCount) * solve(leftCount) * solve(A.length-1-leftCount) % (10^9+7);
            }
            else{
                num = nCk(A.length-1, leftCount) * solve(leftCount) * solve(A.length-1-leftCount) % (10^9+7) - 2;
            }


            return num;
        }

        public int solve(int n){
            int leftCount = calculateLN(n);
            return nCk(n-1, leftCount) * solve(leftCount) * solve(n-1-leftCount) % (10^9+7);
        }


        public int calculateLN(int n){

            if(n==0){
                return 1;
            }

            int h
                    = (int) Math.floor(Math.log((float)n)/Math.log(2.0));

            int maxAtH= 2^h;
            int numAtH = n-(2^(h-1));
            if(numAtH>=maxAtH/2){
                return maxAtH-1;
            }
            else{
                return numAtH;
            }

        }

        public int nCk(int n, int k){
            if(n<=1 || k==0){
                return 1;
            }
            if(k>n || k<0){
                return 0;
            }

            if(dpStore[n][k]==-1){
                dpStore[n][k] = nCk(n-1, k-1) + nCk(n-1, k);
            }

            return dpStore[n][k];
        }



}
