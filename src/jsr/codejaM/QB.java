package jsr.codejaM;

import java.util.Scanner;

public class QB {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();

            for(int i = 1; i<=t; i++){
                long n = in.nextLong();
                long nextLevel;
                long count = in.nextLong();
                long level = in.nextLong();
                nextLevel = level;
                for(int k=1; k<n; k++){
                    long nextCount = in.nextLong();
                    nextLevel = in.nextInt();
                    count = Math.max(0, count-nextCount*nextLevel);
                    count += nextCount;
                    level = Math.max(level, nextLevel);
                }
                System.out.println("Case #" + i + ": " + Math.max(count, level+1));
            }

    }
}
