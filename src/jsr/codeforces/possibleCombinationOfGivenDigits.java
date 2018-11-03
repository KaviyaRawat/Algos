package jsr.codeforces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class possibleCombinationOfGivenDigits {
    static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       long N = in.nextInt();
       HashMap<Long, Long> map = new HashMap<>();


       while(N>0){
           long n= N%10;
           N=N/10;
           if(map.get(n)==null) {
               map.put(n, 0l);
           }
           map.put(n, map.get(n)+1);
       }

        long[] answer = {0};

       possibleNumbers(map, 0).forEach(map1-> {

           answer[0] += possibleCombinations(map1, true);
       });

        System.out.println(answer[0]);


    }

    public static ArrayList<HashMap<Long, Long>> possibleNumbers(HashMap<Long, Long> map, int val){

        ArrayList<HashMap<Long, Long>> answer = new ArrayList<>();
        int tempVal = val;
        if(val>map.size()-1){
            return answer;
        }
        for(Map.Entry<Long, Long> entry: map.entrySet()){

            if(val==0){

                ArrayList<HashMap<Long, Long>> temp = possibleNumbers(map, tempVal+1);
                if(temp.size()!=0) {
                    temp.forEach(map2 -> {
                        long count = entry.getValue();
                        while (count != 0) {
                            HashMap<Long, Long> mapTemp = (HashMap<Long, Long>) map2.clone();

                            mapTemp.put(entry
                                    .getKey(), count);
                            answer.add(mapTemp);
                            count--;
                        }
                    });
                }
                else{
                    long count = entry.getValue();
                    while (count != 0) {
                        HashMap<Long, Long> mapTemp = new HashMap<Long, Long>();

                        mapTemp.put(entry
                                .getKey(), count);
                        answer.add(mapTemp);
                        count--;
                    }
                }
            }
            val--;
        }
        return answer;

    }

    private static long possibleCombinations(HashMap<Long, Long> map, boolean first) {
        if(map.size()==1){
            return 1;
        }
        long count = 0;

        for(Map.Entry<Long, Long> entry: map.entrySet()){
            if(first && entry.getKey()==0){

            }
            else{
                HashMap<Long, Long> map2 = new HashMap<>(map);
                if(entry.getValue()==1)
                    map2.remove(entry.getKey());
                else{
                    map2.put(entry.getKey(), entry.getValue()-1);
                }
                count = count + possibleCombinations(map2, false);
            }

        }

        return count;

    }


}
