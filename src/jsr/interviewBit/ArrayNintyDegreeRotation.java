package jsr.interviewBit;

import java.util.ArrayList;

public class ArrayNintyDegreeRotation {

        public static  void rotate(ArrayList<ArrayList<Integer>> a) {

            for(int i=a.size()-1; i>(a.size()-1)/2; i--){
                int first = a.size()-1-i;
                int last = i;
                for(int j=0; j<Math.ceil((float)(a.size()))/2; j++){
                    int dec_index = a.size()-1-j;

                    int temp = a.get(j).get(first);
                    a.get(j).set(first, a.get(last).get(j));


                    a.get(last).set(j, a.get(dec_index).get(last));


                    a.get(dec_index).set(last, a.get(first).get(dec_index));


                    a.get(first).set(dec_index, temp);

                }

            }



        }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(list2);
        list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(4);
        list.add(list2);
        list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(4);
        list.add(list2);
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        rotate(list);
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }


}
