package jsr.codeforces;

import java.util.*;

public class DSuitAndTie {

    static HashSet<LinkedList<Integer>> dp = new HashSet<>();
    static HashMap<LinkedList<Integer>, Integer> dpMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int N = in.nextInt();

        for (int i=0; i<2*N; i++){
            list.add(in.nextInt());
        }

        System.out.println(minSwaps(list, 0, new HashSet<>()));
    }

    private static int minSwaps(LinkedList<Integer> list, int index, HashSet<Integer> set) {
        if(dpMap.get(list)!=null){
            return dpMap.get(list);
        }

        if(set.size()==list.size()/2){
            return 0;
        }

        if(index==list.size())
            return -1;

        if(set.contains(list.get(index))){
            return minSwaps(list, index+1, set);
        }
        int ans = Integer.MAX_VALUE;

        LinkedList<Integer> list1 = new LinkedList<>(list);

        int val1 = minSwaps(list, index+1, set);
        if(val1!=-1)
            ans = Math.min(val1, ans);

        int index2 = -1;
        for(int i=0; i<list.size(); i++){
            if(i!=index && list.get(i)==list.get(index)) {
                index2 = i;
                break;
            }
        }

        int swaps;
        int val2;
        HashSet<Integer> set2 = new HashSet<>(set);
        set2.add(list.get(index));

        if(index2>index){
            swaps = index2-index-1;
            int temp = list1.get(index2);
            list1.remove(index2);
            list1.add(index+1, temp);
            val2 = minSwaps(list1, index+2, set2);
        }
        else{
            swaps = index - index2-1;
                int temp = list1.get(index2);
                list1.add(index-1, temp);
            list1.remove(index2);
            val2 = minSwaps(list1, index+1, set2);
        }
            if(val2!=-1)
                ans = Math.min(ans, val2+swaps);

        if(val1==-1 && val2==-1)
            return -1;
        dpMap.put(list, ans);
        return ans;
    }

}
