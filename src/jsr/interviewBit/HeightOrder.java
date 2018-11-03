package jsr.interviewBit;

import java.util.ArrayList;

public class HeightOrder {

    class hgtOrder{
        int hgt;
        int order;
        public hgtOrder (int h, int o){
            hgt = h;
            order = o;
        }
    }




    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<hgtOrder> list = new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<A.size(); i++){
            list.add(new hgtOrder(A.get(i), B.get(i)));
        }

        list.sort((o1,o2)-> Integer.valueOf(o1.hgt).compareTo(o2.hgt));

        ans.add(list.get(list.size()-1).hgt);

        for(int i=list.size()-2; i>=0; i--){
            int index = list.get(i).order;
            ans.add(index, list.get(i).hgt);
        }

        return ans;

    }


}
