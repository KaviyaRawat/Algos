package jsr.codeforces;

import java.util.*;

public class CGroup {
    public static class interval{
        long val;
        boolean start;
        interval(int v, boolean s){
            val = v;
            start = s;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        Queue<interval> queue = new PriorityQueue<>(new Comparator<interval>() {
            @Override
            public int compare(interval o1, interval o2) {
                return new Long(o1.val).compareTo(o2.val);
            }
        });
        long max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            queue.add(new interval(in.nextInt(), true));
            int end = in.nextInt();
            max = Math.max(max, end);
            queue.add(new interval(end, false));
        }

        HashMap<Long, Long> ans = new HashMap<>();
        List<Long> list = new ArrayList<>();
        long[] count = {1};
        long prevEnd = -1;
        while(!queue.isEmpty()) {
            interval intrvl = queue.poll();
            if (intrvl.start) {
                list.add(intrvl.val);
            } else {
                for (int i = 1; i < list.size(); i++) {
                    if (ans.get(count[0]) == null) {
                        ans.put(count[0], 0l);
                    }
                    ans.put(count[0], ans.get(count[0]) + (list.get(i) - list.get(i - 1)));
                    count[0]++;
                }
                if(ans.get(count[0]) == null) {
                    ans.put(count[0], 0l);
                }
                if(list.size()!=0)
                    ans.put(count[0], ans.get(count[0]) + intrvl.val - list.get(list.size() - 1));
                else
                    ans.put(count[0], ans.get(count[0]) + intrvl.val-prevEnd);
                            count[0]--;
                list = new ArrayList<>();
                prevEnd = intrvl.val;
            }
        }
        for(long i=1; i<=N; i++){
            if(ans.get(i)==null)
            System.out.println(0 + " ");
            else
                System.out.println(ans.get(i));
        }

    }
}
