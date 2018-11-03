
import java.util.*;


public class LongestSequenceNumbers {

        static long longestSequence(long[] a) {
            long num = 0;
            long count = 0;
            //  Return the length of the longest possible sequence of moves.
            for(int j=0; j<a.length; j++) {
                long size = a[j];
                List<Long> primes = primes(a[j]);


                if(primes.size()==2){
                    count = count + a[j];
                }
                else {
                    while (size != 1) {

                    }
                }
            }

            return num;
        }

        static ArrayList<Long> primes(long n) {
            ArrayList<Long> list = new ArrayList<>();
            long temp = n;
            while(temp>2) {

            }


            return list;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            long result = longestSequence(a);
            System.out.println(result);
            in.close();
        }

}
