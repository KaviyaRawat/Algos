package jsr.interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonLines {
    public static class Solution {
        public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
            if(a.size()==0){
                return 0;
            }
            HashMap<Double, Integer> map = new HashMap<>();

            int max = 1;
            for(int i = 0; i<a.size()-1; i++){
                HashMap<Double, Integer> map2 = new HashMap<>();
                for(int j=i+1; j<a.size(); j++){
                    double m;
                    if(a.get(i)-a.get(j)!=0) {
                        m = (b.get(i) - b.get(j)) / (a.get(i) - a.get(j));

                    }
                    else{
                        m = Integer.MAX_VALUE;
                    }

                    if(map.get(m)==null){
                        int count = 0;
                        if(map2.get(m)!=null){
                            count = map2.get(m);
                        }
                        map2.put(m, count+1);
                    }
                }

                for(Map.Entry<Double, Integer> entry : map2.entrySet()){
                    entry.setValue(entry.getValue()+1);
                    max = Math.max(max, entry.getValue());
                    map.put(entry.getKey(), entry.getValue());
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);

        System.out.println(new Solution().maxPoints(list1, list2));
    }

}
