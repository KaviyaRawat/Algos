package jsr.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findRange {

        // DO NOT MODIFY THE LIST
        public static  ArrayList<Integer> searchRange(final List<Integer> a, int b) {

            ArrayList arr = new ArrayList<Integer>();

            arr.add(-1);
            arr.add(-1);

            if(a.size()==0 || (a.get(0)>b ) || a.get(a.size()-1)<b){
                return arr;
            }

            int left =0;
            int right = a.size()-1;

            while(left<right-1){
                int mid = left + (right-left)/2;
                if(a.get(mid)<b){
                    left = mid;
                }
                else if(a.get(mid)>b){
                    right = mid;
                }
                else{
                    arr = new ArrayList<>();
                    arr.add(searchLeftRange(a, 0, mid));
                    arr.add(searchRightRange(a, a.size()-1, mid));
                    return arr;
                }
            }

            if(a.get(left) == b){
                arr = new ArrayList<>();
                arr.add(left);
                arr.add(left);
            }

            return  arr;

        }

        public static int searchLeftRange(final List<Integer> a, int left, int b){
            int prevLeft = left;
            int mid =b;
            while(left<b-1){
                if(a.get(left)==a.get(mid)){
                    if(prevLeft == left)
                        return left;
                    return searchLeftRange(a,prevLeft, left);

                }
                else{
                    prevLeft = left;
                    left = (left+mid)/2;
                }
            }
            if(a.get(left)==a.get(mid)){
                return left;

            }
            return mid;

        }

        public static int searchRightRange(final List<Integer> a,int right, int b){
            int mid =b;
            int prevRight = right;
            while(right-1>=b){
                if(a.get(right)==a.get(mid)){
                    if(prevRight == right)
                        return right;
                    return searchRightRange(a,prevRight, right);

                }
                else{
                    prevRight = right;
                    right = (right+mid)/2;
                }
            }
            if(a.get(right)==a.get(mid)){
                return right;

            }
            return b;

        }


    public static void main(String[] args) {
            List<Integer> a = Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
                    System.out.println(searchRange(a, 3));
            }





}
