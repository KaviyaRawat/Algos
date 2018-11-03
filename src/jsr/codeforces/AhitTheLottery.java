package jsr.codeforces;

import java.util.Scanner;

public class AhitTheLottery {

    public static void main(String[] args) {

        int[] bills = {1,5,10,20,100};
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int count = 0;
        int j=4;
        while(N!=0){
            count += N/bills[j];
            N=N%bills[j];
            j--;

        }
        System.out.println(count);
    }
}
