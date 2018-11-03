package jsr.codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class A496 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int prev = in.nextInt();
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<N; i++){
            int curr = in.nextInt();
            if(curr==1){
                count++;
                list.add(prev);
            }
            prev = curr;
        }
        list.add(prev);
        System.out.println(count);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

}
