package jsr.interviewBit;

import java.util.HashMap;

public class IntToRoman {

    public static class Solution {
        public String intToRoman(int A) {

            int digits[] = new int[4];
            int temp = A;
            String[] romanNumerals = {"I", "V", "X", "L", "C", "D", "M"};
            String one = "I";
            String five = "V";
            String ten = "X";
            String fifty = "L";
            String hundred = "C";
            String fiveHundred = "D";
            String thousand = "M";

            for(int i=0; i<4; i++){
                digits[i] = temp%10;
                temp = temp/10;
            }

            String roman = "";;


            for(int j=3; j>=0; j--){
                int index =(j)*2;
                String num = romanNumerals[index];
                for(int i=0;i<digits[j];i++){

                    if(digits[j]==4){
                        roman = roman + romanNumerals[index] + romanNumerals[index+1];
                        break;
                    }

                    if(digits[j]==9){
                        index = index + 2;
                        roman = roman + romanNumerals[index-2]
                                + romanNumerals[index];
                        break;
                    }

                    if(digits[j]>4){
                        roman = roman + romanNumerals[index+1];
                        digits[j] = digits[j] - 5;
                        i=-1;

                    }

                    else{
                        roman = roman + romanNumerals[index];
                    }

                }
            }


            return roman;

        }
        public int romanToInt(String A) {
            int num=0, prevNum=Integer.MIN_VALUE;
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            for(int i=A.length()-1; i>=0; i--){
                int currentNumber = map.get(A.charAt(i));
                if(prevNum<=currentNumber){
                    num = num+currentNumber;
                }
                else{
                    num = num-currentNumber;
                }
                prevNum=currentNumber;
            }
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(8));
        System.out.println(new Solution().romanToInt("IX"));
    }



}
