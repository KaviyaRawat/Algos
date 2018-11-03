package jsr.interviewBit;

import java.util.ArrayList;

public class EightDirGridTraversl {
    static int[] xx = {
            1,-1,
            0,0,
            -1,-1,
            1,1
    };
    static int[] yy = {
            0,0,
            1,-1,
            -1,1,
            -1,1
    };

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count = 0;
        if(A.size()==1){
            return 0;
        }
        else{
            for(int i=0; i<A.size()-1;i++){
                ArrayList<Integer> list1 = new ArrayList<>();
                ArrayList<Integer> list2 = new ArrayList<>();
                list1.add(A.get(i));
                list1.add(B.get(i));
                list2.add(A.get(i+1));
                list2.add(B.get(i+1));
                count = count + coverTwoPoints(list1,list2);
            }
        }
        return count;
    }



    public static int coverTwoPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count;
        int min = 0;
        int xxVal;
        int yyVal;
        if(A.get(0).equals(B.get(0)) && A.get(1).equals(B.get(1))){
            return 0;
        }
        ArrayList<Integer> Anew = new ArrayList<>();
        if(A.get(0)-B.get(0)>0){
            xxVal = -1;
        }
        else if(A.get(0)-B.get(0)<0){
            xxVal = 1;
        }
        else{
            xxVal = 0;
        }
        if(A.get(1)-B.get(1)>0){
            yyVal = -1;
        }
        else if(A.get(1)-B.get(1)<0){
            yyVal = 1;
        }
        else{
            yyVal = 0;
        }
            Anew = new ArrayList<>();
            Anew.add(A.get(0)+xxVal);
            Anew.add(A.get(1)+yyVal);
            count = 1+ coverTwoPoints(Anew,B);


        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(-7);
        list1.add(-13);
        list2.add(1);
        list2.add(-5);
        System.out.println(coverPoints(list1,list2));
    }


}
