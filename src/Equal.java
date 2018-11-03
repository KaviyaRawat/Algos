import java.util.Arrays;
import java.util.Scanner;

public class Equal {

        private static int counts[] = {1,2,5};


        static int equal(int[] arr){
            // Complete this function

            if(isEqual (arr)){
                return 0;
            }
            int cnt =0;
            int[] count = new  int[3];

            int[] arr2;

            int n = findMax(arr);
            for(int j=0;j<3;j++){
                arr2 = Arrays.copyOfRange(arr, 0, arr.length);
                for(int i=0; i<arr.length; i++){
                    if(i!=n){
                        arr2[i] = arr2[i] + counts[j] + 1;
                    }
                }
                count[j] = count[j] + equal(arr2);
            }
            cnt = Math.min(count[0], count[1]);
            cnt = Math.min(count[2], cnt);

            return cnt;
        }
        static boolean isEqual(int[] arr){
            for(int i=0; i<arr.length-1; i++){
                if(arr[i]!=arr[i+1])
                    return  false;

            }
            return true;
        }
        static int findMax(int[] arr){
            int max = arr[0];
            int index = 0;
            for(int i=1; i<arr.length; i++){
                if(max<arr[i]){
                    index = i;
                    max = arr[i];
                }
            }
            return index;
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
                int result = equal(arr);
                System.out.println(result);
            }
            in.close();
        }
    }


