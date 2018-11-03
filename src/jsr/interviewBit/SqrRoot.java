package jsr.interviewBit;

public class SqrRoot {



    public static  int sqrt(int a) {
        if(a==0)
            return 0;
        if(a==1)
            return 1;
        long left = 0;
        long right = a;
        long ans = (left+right)/2;
        while(right-left>1){

            long sqr = ans*ans;
            if(sqr == a){
                return (int)ans;
            }
            else if(sqr>a){
                right = ans-1;
            }
            else{
                left = ans+1;
            }
            ans = (left+right)/2;

        }
        return (int)left;

    }

    public static void main(String[] args) {
        System.out.println(sqrt(7));
    }

}
