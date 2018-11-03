package jsr.interviewBit;

import java.util.ArrayList;
import java.util.List;

public class SearchInRotatedArray {




    public static class Solution {
        // DO NOT MODIFY THE LIST
        public int search(final List<Integer> a, int b) {
            int left = 0;
            int N = a.size();
            int right = N-1;
            int mid = left+(right-left)/2;
            while(left<right){
                if(a.get(left)<a.get(right)){
                    return
                            searchBinary(a, left, right, b);
                }

                if(a.get(mid)==b){
                    return mid;
                }

                if(a.get(mid)<=a.get(right)){
                    if(a.get(right)<b){
                        right = mid;
                    }
                    else{
                        if(a.get(mid)>b){
                            right = mid;
                        }
                        else{
                            left = mid;
                        }

                    }
                }
                else{
                    if(a.get(left)>b){
                        left = mid;
                    }else{
                        if(a.get(mid)<b){
                            left=mid;
                        }else {
                            right = mid;
                        }
                    }

                }

                mid = left+(right-left)/2;

            }


            return -1;
        }

        public int searchBinary(final List<Integer> a, int left, int right, int b){
            int mid = left+ (right - left)/2;
            while(left<=right){
                if(a.get(mid)==b){
                    return mid;
                }
                else{
                    if(a.get(mid)>b){
                        right = mid-1;
                    }
                    else{
                        left = mid+1;
                    }
                }
                mid = left+ (right-left)/2;

            }

                return -1;
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Integer[] array = {194, 198, 201, 203, 2, 3, 7, 9, 11, 12, 18, 20, 23, 25, 27, 29, 30, 31, 36, 37, 43, 44, 48, 51, 53, 54, 56, 59, 60, 61, 66, 67, 70, 71, 72, 73, 74, 76, 78, 80, 82, 84, 87, 91, 92, 93, 94, 97, 99, 100, 101, 102, 104, 108, 109, 111, 112, 113, 115, 117, 118, 120, 122, 124, 126, 131, 133, 136, 137, 138, 143, 148, 151, 152, 153, 155, 156, 157, 159, 161, 162, 163, 164, 167, 170, 171, 173, 174, 175, 180, 182, 184, 190};
        for (int i = 0; i < array.length; i++) {
            a.add(array[i]);
        }
        Solution S = new Solution();
        S.search(a, 23);
    }

}
