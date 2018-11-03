import java.util.Scanner;

public class BasketFall {
    public static void main(String args[] ) throws Exception {
        int T,N;
        long a, b, t;
        int x;
        int xi;
        Scanner in = new Scanner(System.in);

        T = in.nextInt();
        for(int i=0; i<T; i++){
            N = in.nextInt();
            int array[] = new int[N];
            int check[] = new int[N];

            for(int k=0; k<N; k++){
                array[k] = in.nextInt();
            }
            x = in.nextInt();
            a = in.nextLong();
            b = in.nextLong();
            t = in.nextLong();
            check[x]++;
            int count = 0;
            for(int j=1; j<t; j++){
                long some = (a*x+b);
                xi = (int) (some%N);
                x = xi;
                check[xi]++;
                if(array[xi] == check[xi]){
                    check[xi]=0;
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
