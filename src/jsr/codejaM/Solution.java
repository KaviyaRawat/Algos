package jsr.codejaM;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=1; i<=t; i++){
            int n = in.nextInt();
            int[] arr= new int[n];
            for(int j=0; j<n; j++){
                arr[j]=in.nextInt();
            }

            int ans = troublesort(arr);
            // int ans = isSorted(arr);
            if(ans==100001){
                System.out.println("Case #" + i + ": " + "OK");
            }
            else{
                System.out.println("Case #" + i + ": " + ans);
            }
        }
    }

    private static int isSorted(int[] arr) {
        for(int i=0;i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                return i;
            }
        }
        return -1;
    }

    private static int troublesort(int[] arr) {
        boolean swap = true;
        int ans = 100001;
        while(swap) {
            swap=false;
            for (int i = 0; i < arr.length - 2; i++) {
                if (arr[i] > arr[i + 2]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 2];
                    arr[i + 2] = temp;
                    swap = true;
                }
            }
            for (int i = 0; i < arr.length - 2; i++) {
                if (arr[i + 1] < arr[i] && (i - 1 < 0 || arr[i - 1] < arr[i + 1]) && ((arr[i + 2] > arr[i]) || arr[i + 2] > arr[i + 1])) {
                    ans = Math.min(ans, i);
                }

                if (arr[i + 2] < arr[i + 1] && (i + 3 > arr.length - 1 || arr[i + 3] > arr[i + 1]) && ((arr[i + 2] > arr[i]) || arr[i] < arr[i + 1])) {
                    ans = Math.min(ans, i+1);
                }
            }
        }


        return ans;

    }

}
