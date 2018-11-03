package jsr.codeforces;

import java.util.Scanner;

public class B497 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int x=in.nextInt();
        int y=in.nextInt();
        int h;
        h = Math.max(x,y);
        boolean ans = true;
        for(int i=1; i<N; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            if(Math.max(a,b)<=h){
                h=Math.max(a,b);
            }
            else if(Math.min(a,b)<=h){
                h=Math.min(a,b);
            }
            else{
                ans = false;
                break;
            }
        }
        if(ans)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
