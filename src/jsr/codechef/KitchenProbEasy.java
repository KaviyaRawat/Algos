package jsr.codechef;

import java.util.ArrayList;
import java.util.Scanner;

public class KitchenProbEasy {

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
        for(int i=0; i<T; i++) {
            int n = in.nextInt();
            ArrayList<Pairr> pairs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                pairs.add(new Pairr());
                pairs.get(j).last = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                pairs.get(j).count = in.nextInt();
            }
            System.out.println(getAns(pairs));
        }
    }

    private static int getAns(ArrayList<Pairr> pairs) {
        int ans = 0;
        int time1 = 0;
        for(int i=0; i<pairs.size(); i++){
            if(time1+pairs.get(i).count<=pairs.get(i).last){
                ans++;
            }
            time1=pairs.get(i).last;
        }
        return ans;
    }
}
