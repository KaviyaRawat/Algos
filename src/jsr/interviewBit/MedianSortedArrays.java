package jsr.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianSortedArrays {
        // DO NOT MODIFY BOTH THE LISTS
        public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
            if(a.size()==0 && b.size()==0){
                return 0;

            }
            int m = a.size();
            int n = b.size();
            if((a.size()+b.size())%2==0){
                return (findKElement(a, 0, b, 0, (m+n)/2)+findKElement(a, 0, b, 0, (n+m)/2-1))/2;
            }
            else{
                return findKElement(a, 0, b, 0, (m+n)/2);
            }

        }

    public static double findKElement(List<Integer>  a, int startA, List<Integer>  b, int startB, int K){
        if(startA>=a.size()){
            return b.get(startB+K);
        }
        if(startB>=b.size()){
            return a.get(startA+K);
        }

        if(K==1){
            return Math.max(a.get(startA), b.get(startB));
        }

        if(startA+K/2<a.size() && a.get(startA+K/2)<b.get(startB+K/2)){
            return findKElement(a, startA+K/2, b, startB, K-K/2);
        }
        else{
            return findKElement(a, startA, b, startB+K/2, K-K/2);
        }


    }

    public static void main(String[] args) {

            List<Integer> a = Arrays.asList(new Integer[]{ -50, -41, -40, -19, 5, 21, 28 });
            List<Integer> b = Arrays.asList(new Integer[]{-50, -21, -10 });

            System.out.println(findMedianSortedArrays(a,b));

        }


    }
