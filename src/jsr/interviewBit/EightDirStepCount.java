package jsr.interviewBit;

import java.util.ArrayList;

public class EightDirStepCount {
    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count = 0;
        for(int i=0; i< A.size()-1; i++){
            count += Math.max(Math.abs(A.get(i)-A.get(i+1)), Math.abs((B.get(i)-B.get(i+1))));
        }
        return count;
    }
}
