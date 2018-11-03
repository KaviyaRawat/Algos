package jsr.codeforces;

import java.util.Scanner;

public class BFanAreaEntr {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int min = 0;
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (num > getAnInt(array[i], i) / N) {
                if (getAnInt(array[i], i) % N == 0) {
                    num = getAnInt(array[i],i) / N;
                    min = i;
                } else if (((getAnInt(array[i] , i) / N) + 1) < num) {
                    num = (getAnInt(array[i] , i) / N) + 1;
                    min = i;
                }
            }
        }

        System.out.println(min + 1);

    }

    private static int getAnInt(int i, int i2) {
        if(i-i2>=0)
            return (i-i2);
        else
            return 0;
    }
}
