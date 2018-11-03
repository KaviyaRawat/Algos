
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxDP {

        static int cost(int[] arr) {
        // Complete this function

        return Math.max(cost(arr, true), cost(arr, false));

    }

    static int cost(int[] arr, boolean isPositive){
        if(arr.length == 0)
            return 0;
        else if (arr.length==1){
            if(isPositive)
                return 0;
            else
                return 0;
        }
        else{
            if(isPositive){
                return Math.abs(arr[0] - 1) +
                        cost(Arrays.copyOfRange(arr, 1, arr.length), false);
            }
            else{
                return  Math.abs(arr[1] - 1) +
                        cost(Arrays.copyOfRange(arr, 1, arr.length), true) ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = cost(arr);
            System.out.println(result);
        }
        in.close();
    }

}