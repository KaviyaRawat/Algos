package jsr.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class C497 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }
            if (N == 1)
                System.out.println(0);
            else {
                Arrays.sort(arr);
                int prev = arr[0];
                int prevSmaller = 0;
                int count = N;
                int i = 1;


                while (i <= N - 1) {
                    int currSmaller = 1;
                    while (i <= N - 1 && prev == arr[i]) {
                        currSmaller++;
                        i++;
                    }
                    if (prevSmaller <= currSmaller) {
                        count -= (currSmaller - prevSmaller);
                        prevSmaller = currSmaller;
                    }
                    if (i <= N - 1)
                        prev = arr[i];
                    i++;
                }

                System.out.println(count);
            }
        }


}
