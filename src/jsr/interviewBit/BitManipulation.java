package jsr.interviewBit;

import java.util.Arrays;
import java.util.List;

public class BitManipulation {
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int hammingDistance(final List<Integer> A) {
            int[] array = new int[32];
            int ans = 0;
            int n = A.size();
            for(int i=0; i<A.size(); i++){
                int k = A.get(i);
                for(int j=0; j<31; j++){
                    array[j] += (k&(1<<j))!=0?1:0;
                    //k=k&(~(1<<j));
                }
            }


            for(int i=0; i<32; i++){
                ans += 2 * array[i] * (n-array[i]) % 1000000007;
            }


            return ans % 1000000007;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,6);
        System.out.println(new Solution().hammingDistance(list));
    }

}
