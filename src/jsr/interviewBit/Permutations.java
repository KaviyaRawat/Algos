package jsr.interviewBit;

import java.util.ArrayList;
import java.util.HashMap;

public class Permutations {
    public static class Solution {
        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int N = A.size();
            for(int i=0; i<A.size(); i++){
                int count = 0;
                if(map.get(A.get(i))!=null){
                    count = map.get(A.get(i));
                }
                map.put(A.get(i), ++count);
            }

            return permute(A, map, 0);

        }

        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A,
                                                     HashMap<Integer, Integer> map, int index){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            if(index == A.size()){
                return list;
            }
            map.forEach((key, value)->{
                ArrayList<Integer> list1 = new ArrayList<>();
                ArrayList<Integer> list2 = new ArrayList<>();
                if(value>0){
                    list1.add(key);
                    map.put(key, value-1);
                    ArrayList<ArrayList<Integer>> subLists =
                            permute(A, new HashMap<>(map), index+1);
                    map.put(key, value);
                    if(subLists.size()==0){
                        list.add(list1);
                    }
                    else{
                        for(int i=0; i<subLists.size(); i++){
                            ArrayList<Integer> subList = subLists.get(i);
                            list2=new ArrayList<>(list1);
                            list2.addAll(subList);
                            list.add(list2);

                        }
                    }

                }

            });



            return list;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        /*ArrayList<ArrayList<Integer>> lists = new Solution().permute(A);
        lists.forEach(list->{

            System.out.println(list);
                });*/
        System.out.println(new Solution().permute(A));
    }


}
