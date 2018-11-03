package jsr.interviewBit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WindowMaxSliding {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        if(A==null || A.size()==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> C  = new ArrayList<>();
        if(B>A.size()){
            C.add(1);
            return C;
        }
        LinkedList<Integer> q = new LinkedList<>();
        q.add(A.get(0));

        for(int i=1; i<A.size(); i++){
            int counter = 0, val;
            int n = q.size()-1;
            while(!q.isEmpty() && q.peekLast()<A.get(i)){
                q.pollLast();
                counter++;
            }

            while(counter>=0){
                q.addLast(A.get(i));
                counter--;
            }
            if(i>=B){
                C.add(q.poll());
            }

        }
        return C;
    }
}
