package jsr.interviewBit;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayPrint {
        public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            for(int i =0; i<A; i++){
                list = new ArrayList<>();
                int count=0;
                int num = A;
                for(int j =0; j< A; j++){
                    list.add(num);
                    if(count<i){
                        num--;
                        count++;
                    }
                }


                for(int j=A-2; j>=0; j--){
                    list.add(list.get(j));
                }
                lists.add(list);
            }
            for(int j=A-2; j>=0; j--){
                lists.add(lists.get(j));
            }
            return lists;
        }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists =
                prettyPrint(3);
        lists.forEach(list->{
            System.out.println(list);
        });
    }
}
