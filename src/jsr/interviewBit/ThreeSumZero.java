package jsr.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumZero {

    public static class Solution {
        public ArrayList<ArrayList<Integer>> threeSum(List<Integer> A) {

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            if(A==null || A.size()<3){
                return list;
            }

            Collections.sort(A);

            for(int i=A.size()-1; i>=2; i--){
                if(i==A.size()-1 || A.get(i)!=A.get(i+1)){

                    int left = 0;
                    int right = i-1;

                    while(left<right){

                        if(A.get(i)==-1*(A.get(left)+A.get(right))){
                            ArrayList<Integer> list1 = new ArrayList<>();

                            list1.add(A.get(left));
                            list1.add(A.get(right));
                            list1.add(A.get(i));

                            list.add(list1);
                            while(left+1<A.size() && A.get(left)==A.get(left+1)){
                                left++;
                            }
                            left++;
                            while(right-1>=0 && A.get(right)==A.get(right-1)){
                                right--;
                            }
                            right--;
                        }

                        else if(A.get(i)<-1*(A.get(left)+A.get(right))){
                            left++;
                        }

                        else if(A.get(i)>-1*(A.get(left)+A.get(right))){
                            right--;
                        }

                    }
                }

            }



            return list;
        }
    }




    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(-2, 4, 3, 3, 5, -2, 1);
                System.out.println(new Solution().threeSum(list));
    }

}
