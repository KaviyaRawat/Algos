package jsr.interviewBit;

import java.util.ArrayList;
import java.util.HashMap;

public class FourValuesWithSum {


    public static class Solution {
        public ArrayList<Integer> equal(ArrayList<Integer> A) {

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for(int i=0; i<A.size(); i++){
                ArrayList<Integer> list = new ArrayList<>();
                if(map.get(A.get(i))!=null){
                    list = map.get(A.get(i));
                }
                list.add(i);
                map.put(A.get(i), list);

            }

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<A.size(); i++){
                for(int j=i+1;j<A.size(); j++){

                    int sum = A.get(i)+A.get(j);

                    for(int k=i+1; k<A.size(); k++){
                        if(k!=j){
                            if(map.get(sum-A.get(k))!=null){
                                ArrayList<Integer> list1 = map.get(sum-A.get(k));
                                int m = 0;
                                while(j==list1.get(m) || m<list1.size()-1 && list1.get(m)<=k){
                                    m++;
                                }
                                if(m<list1.size() && list1.get(m)>k){
                                    list.add(i);
                                    list.add(j);
                                    list.add(k);
                                    list.add(map.get(sum-A.get(k)).get(m));
                                    return list;
                                }
                            }
                        }
                    }

                }
            }

            return list;

        }

    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // 9, 5, 4, 9, 3, 6, 8

        /*list.add(9);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(3);
        list.add(6);
        list.add(8);
*/

        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(2);

        System.out.println(new Solution().equal(list));
    }

}
