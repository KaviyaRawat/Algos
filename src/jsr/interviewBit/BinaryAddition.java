package jsr.interviewBit;

public class BinaryAddition {
    public static class Solution {
        public String addBinary(String A, String B) {
            String longg;
            String shortt;
            String sum = "";


            if(A.length()>B.length()){
                longg = A;
                shortt = B;
            }
            else{
                longg = B;
                shortt = A;
            }
            int N = longg.length() - shortt.length();
            String carry = "0";
            for(int i=shortt.length()-1; i>=0; i--){
                char a=longg.charAt(i+N);
                char b= shortt.charAt(i);
                String threeValues = carry+a+b;
                switch(threeValues){
                    case "000":
                        sum = "0" + sum;
                        carry = "0";
                        break;
                    case "001":
                        sum = "1" + sum;
                        carry = "0";
                        break;
                    case "010":
                        sum = "1" + sum;
                        carry = "0";
                        break;
                    case "011":
                        sum = "0" + sum;
                        carry = "1";
                        break;
                    case "100":
                        sum = "1" + sum;
                        carry = "0";
                        break;
                    case "101":
                        sum = "0" + sum;
                        carry = "1";
                        break;
                    case "110":
                        sum = "0" + sum;
                        carry = "1";
                        break;
                    case "111":
                        sum = "1" + sum;
                        carry = "1";
                        break;
                }


            }

            for(int i=N-1; i>=0; i--){
                char a=longg.charAt(i);
                String twoValues = carry+a;
                switch(twoValues){
                    case "00":
                        sum = "0" + sum;
                        carry = "0";
                        break;
                    case "01":
                        sum = "1" + sum;
                        carry = "0";
                        break;
                    case "10":
                        sum = "1" + sum;
                        carry = "0";
                        break;
                    case "11":
                        sum = "0" + sum;
                        carry = "1";
                        break;

                }
            }
            if(carry.equals("1")){
                sum = 1+sum;
            }
            return sum;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1100", "1111"));
    }

}
