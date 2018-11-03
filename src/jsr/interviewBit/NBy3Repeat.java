package jsr.interviewBit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NBy3Repeat {
    public static class Solution {
        // DO NOT MODIFY THE LIST

        class numct{
            int num;
            int ct;
            public numct(int n, int c){
                num = n;
                ct = c;
            }
        }

        public int repeatedNumber(final List<Integer> a) {
            if(a==null)
                return -1;
            if(a.size()==1 || a.size()==2){
                return a.get(0);
            }
      /*numct first = new numct(a.get(0), 1);
      numct second = null;
      for(int i=1; i<a.size(); i++){

          if(first.num == a.get(i)){
              first.ct = first.ct+1;
          }
          else if(second == null){
               second = new numct(a.get(i), 1);
          }
          else if(second.num == a.get(i)){
              second.ct++;
          }

          else{
                if(first.ct == 0){
                    first = new numct(a.get(i), 1);
                }
                else if(second.ct == 0){
                    second = new numct(a.get(i), 1);
                }
                else{
                    second.ct--;
                    first.ct--;
                }
          }
      }

      if(first.ct>1){
          return first.num;
      }
      if(second !=null && second.ct>1){
          return second.num;
      }*/
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<a.size(); i++){
                if(map.get(a.get(i))!=null){
                    map.put(a.get(i), map.get(a.get(i))+1);
                }
                else{
                    map.put(a.get(i), 1);
                }
            }
            int[] ans = {-1};
            for(java.util.Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue()>a.size()/3){
                    ans[0] = entry.getKey();
                }
            }

            return ans[0];
        }

    }


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2,2,1);
        System.out.println(new Solution().repeatedNumber(list));
    }

}
