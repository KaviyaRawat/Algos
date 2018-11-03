package jsr.codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class BGoodProgram {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int M = in.nextInt();

        int max = Integer.MIN_VALUE;
        int prev = 0;
        boolean switchOn = true;
        ArrayList<Integer> jsr = new ArrayList<>();
        int index = 0;
        int count = 0;

        for(int i=0; i<N; i++){
            int curr = in.nextInt();
            jsr.add(curr);
            int val = curr-prev;
            if(max<val){
                max = val;
                index = i-1;
            }
            prev = curr;

        }
jsr.add(0,0);
        jsr.add(jsr.size(), M);
        for(int i=0; i<N+1; i=i+2){
            count = count + jsr.get(i+1)-jsr.get(i);
        }
jsr.remove(0);
        jsr.remove(jsr.size()-1);
        if(M-prev>max){
            index = N-1;
            max = M-prev;
        }
        jsr.add(M);
        if(index%2!=0){
            jsr.add(index+1, jsr.get(index+1)-1);
        }
        else{
            if(index!=-1)
            jsr.add(index+1, jsr.get(index)+1);
            else{
                jsr.add(index+1, 1);
            }
        }
        jsr.add(0,0);
        int count2 = 0;
        for(int i=0; i<N+2; i=i+2){
            count2 = count2 + jsr.get(i+1)-jsr.get(i);
        }
        if(count2<count)
            System.out.println(count);
        else{
            System.out.println(count2);
        }


    }

}
