package jsr.codechef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KitchenProblem {

    public static class Pairr implements Comparable<Pairr>{

        int last;
        int count;

        @Override
        public int compareTo(Pairr o) {
            return this.last-o.last;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++){
            int n = in.nextInt();
            ArrayList<Pairr> pairs = new ArrayList<>();
            for(int j=0; j<n; j++){
                pairs.add(new Pairr());
                pairs.get(j).last = in.nextInt();
            }
            for(int j=0; j<n; j++){
                pairs.get(j).count = in.nextInt();
            }
            Collections.sort(pairs);
            System.out.println(getMax(pairs,0, 0));
        }
    }

    public static long getMax(ArrayList<Pairr> pairs, int i, long time){
        if(i>=pairs.size()){
            return 0;
        }
        long num=0;

        long val = 0;
        if(time+pairs.get(i).count<=pairs.get(i).last){
            val = time+pairs.get(i).count;
        }
        num = Math.max(getMax(pairs, i+1, time), getMax(pairs, i+1, val)+1);

        return num;


    }

}
