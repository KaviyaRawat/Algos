package jsr.interviewBit;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {


    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> cmmn(final List<Integer> A, final List<Integer> B) {

            ArrayList<Integer> list = new ArrayList<>();
            if(A==null || B==null){
                return list;
            }

            int one = 0;
            int two = 0;

            while(one!=A.size() && two!=B.size()){
                if(A.get(one)==B.get(two)){
                    list.add(A.get(one));
                    one++;
                    two++;
                }
                while(one<A.size() && two<B.size() && A.get(one)<B.get(two)){
                    one++;
                }
                while(one<A.size() && two<B.size() && B.get(two)<A.get(one)){
                    two++;
                }
            }

            return list;

        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // 9, 5, 4, 9, 3, 6, 8

        /*list.add(9);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(3);
        list.add(6);
        list.add(8);
*/

        list1.add(1000000);
        list2.add(1000000);
        System.out.println(new Solution().cmmn(list1, list2));
    }

}
