import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

        private static long[][] dpStore;

        static long getWays(long n, long[] c){
            long count =0;
            if(dpStore[(int)n][c.length]!=0)
                return dpStore[(int)n][c.length];
            if(n==0)
                return 1;
            for(int i=0; i<c.length; i++){
                long temp = n;
                while(temp>0){
                    if(c[i] == temp) {
                        count = count + 1;
                        temp = temp -c[i];
                    }
                    else if(c[i]<temp){
                        temp =  temp - c[i];
                        count = count + getWays(temp, Arrays.copyOfRange(c, i+1, c.length));
                    }
                    else{
                        temp =0;
                    }
                }
            }
            dpStore[(int)n][c.length]=count;
            return count;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            long[] c = new long[m];
            for(int c_i=0; c_i < m; c_i++){
                c[c_i] = in.nextLong();
            }
            // Print the number of ways of making change
            // for 'n' units using coins having the
            // values given
            // by 'c'
            dpStore = new long[n+1][c.length+1];
            long ways = getWays((int)n, c);

            System.out.println(ways);
        }
    }


