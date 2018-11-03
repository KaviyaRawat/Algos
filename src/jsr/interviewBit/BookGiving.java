package jsr.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookGiving {
        public int books(List<Integer> A, int B) {
            if(A.size()==0  && B==0){
                return 0;
            }
            if(A.size()<B || A.size()==0){
                return -1;
            }

            int totalPages = 0;
            int min = A.get(0);

            for(int i=0; i<A.size(); i++){
                min = Math.min(min, A.get(i));
                totalPages +=A.get(i);
            }

            int max = totalPages;
            int mid, currentMin=-1;

            while(min<=max){
                mid = min+(max-min)/2;
                if(isPossible(A, B, mid)){
                    currentMin = mid;
                    max = mid-1;
                }
                else{
                    min = mid+1;
                }
            }

            return currentMin;


        }


        public boolean isPossible(List<Integer> A, int B, int mid){
            int curr = 0;
            B--;
            for(int i=0; i<A.size(); i++){
                if(A.get(i)>mid || B<0){
                    return false;
                }
                if(curr+A.get(i)>mid){
                    curr = 0;
                    B--;
                    curr = curr + A.get(i);

                }
                else{
                    curr = curr + A.get(i);
                }
            }

            if(B<0){
                return false;
            }

            return true;
        }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{12, 34, 67, 90});
        System.out.println(new BookGiving().books(a, 2));
    }

}
