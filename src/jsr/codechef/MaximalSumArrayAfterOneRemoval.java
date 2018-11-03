package jsr.codechef;

import java.util.Scanner;

public class MaximalSumArrayAfterOneRemoval {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int j=0;j<N; j++){
            int n = scanner.nextInt();
            int array[] = new int[n];
            long sum=0;
            for(int i=0;i<n; i++){
                array[i] = scanner.nextInt();
                sum = sum + array[i];
            }
            System.out.println(
                    Math.max(sum,checkMax(array)));
        }

    }

    private static long checkMax(int[] array) {
        long num = 0;
        long ans = Integer.MIN_VALUE;
        int start_ans = 0;
        int start=0;
        int end_ans = 0;
        for(int i=0; i<array.length; i++){
            num = num + array[i];
            if(ans<=num){
                end_ans=i;
                start_ans=start;
                ans = num;
            }
            if(num<0){
                start = i+1;
                num = 0;
            }
        }
        long temp = ans;

        if(start_ans>1){
            long val = ans;
            int i=start_ans-2;
            while(i>=0 && array[i]>0){
                val = val + array[i];
                i--;
            }
            temp = Math.max(temp, val);
        }
        if(end_ans<array.length-2){
            long val = ans;
            int i=end_ans+2;
            while(i<array.length && array[i]>0){
                val = val + array[i];
                i++;
            }
            temp = Math.max(temp, val);
        }
        int i=start_ans;
        int min = Integer.MAX_VALUE;
        while(i<=end_ans){
            min = Math.min(array[i], min);
            i++;
        }
        temp = Math.max(temp, ans-min);
        return temp;
    }

}
