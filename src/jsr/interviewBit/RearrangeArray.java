package jsr.interviewBit;

import java.util.ArrayList;

public class RearrangeArray {

    public static  void arrange(ArrayList<Integer> A) {
        int n = A.size();

        for(int i=0; i<n; i++){
            int value = A.get(i);
            if(value<i){
                A.set(i, (value*n+A.get(value)/n));}
            else{
                A.set(i, (value*n+A.get(value)));}

        }

        for(int i=0; i<n; i++){
            int value;
            value = A.get(i) % n;

            A.set(i, value);
        }
    }


    public static void main(String[] args) {

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(0);
        list2.add(2);
        list2.add(1);
        list2.add(3);
        arrange(list2);

    }

}
