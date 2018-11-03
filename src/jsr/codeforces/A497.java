package jsr.codeforces;

import java.util.Scanner;

public class A497 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        boolean checkVowel = false;
        char ch;
        for(int i=0; i<word.length(); i++){
            if(checkVowel){
                if(!isVowel(word.charAt(i)) ){
                    //System.out.println("NO");
                    break;
                }
                else{
                    checkVowel=false;
                }
            }
            else{
                if(!isVowel(word.charAt(i)) && word.charAt(i)!='n'){
                    checkVowel = true;
                }
            }
        }
        if(checkVowel){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }

    private static boolean isVowel(char c) {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }

}
