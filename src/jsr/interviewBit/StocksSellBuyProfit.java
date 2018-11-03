package jsr.interviewBit;

import java.util.ArrayList;
import java.util.List;

public class StocksSellBuyProfit {
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        int
                dpStore[][];
        // 0 holdStock before this index, 1 does not holdStock
        public int maxProfit(final List<Integer> A) {
            if(A==null || A.size()==0){
                return 0;
            }

            dpStore = new int [A.size()][2];
            for(int i=0; i<A.size(); i++){
                for(int j=0; j<2; j++){
                    dpStore[i][j] = -1;
                }
            }

            return Math.max( A.get(0)*-1 + maxProfit(A, true, 1), maxProfit(A, false, 1));

        }


        public int maxProfit(List<Integer> A, boolean holdStock,  int index){
            if(index== A.size()){
                return 0;
            }

            if(holdStock){
                if(dpStore[index-1][0]==-1){
                    dpStore[index-1][0] = Math.max(
                            A.get(index) + maxProfit(A, false,  index+1),
                            maxProfit(A, true, index+1));

                }
                return dpStore[index-1][0];
            }
            else{
                if(dpStore[index-1][1]==-1){
                    dpStore[index-1][1] = Math.max(
                            maxProfit(A, false, index+1),
                            maxProfit(A, true, index+1)-A.get(index));
                }
                return dpStore[index-1][1];
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        System.out.println(new Solution().maxProfit(list));
    }

}
