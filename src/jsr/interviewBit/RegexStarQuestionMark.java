package jsr.interviewBit;

public class RegexStarQuestionMark {

    public static  class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY

        int dpStore[][] ;

        public int isMatch(final String A, final String B) {

            dpStore = new int[A.length()][B.length()];

            for(int i=0; i<A.length(); i++){
                for(int j=0; j<B.length(); j++){
                    dpStore[i][j] = -1;
                }
            }

            return    isMatch(A, B, 0,0);
        }

        public int isMatch(final String A, final String B, int a, int b){
            if(a==A.length() && b==B.length()){
                return 1;
            }
            if(a==A.length()){
                if(B.charAt(b)=='*'){
                    return isMatch(A, B, a, b+1);
                }
                return 0;
            }
            if(A.substring(a).equals(B.substring(b)) || B.substring(b).equals("*")){
                dpStore[a][b] = 1;
                return 1;
            }
            if(a==A.length()) {
                return 0;
            }


            /*if(dpStore[a][b]!=-1){
                return dpStore[a][b];
            }*/

            int index = a;
            int i = b;
                if(B.charAt(i)=='*'){

                    if(isMatch(A, B,index+1, i)==1){
                        dpStore[a][b] = 1;
                        return 1;
                    }
                    if(isMatch(A,B,index+1,i+1)==1){
                        dpStore[a][b] = 1;
                        return 1;
                    }
                    if(isMatch(A, B, index, i+1)==1){
                        dpStore[a][b] = 1;
                        return 1;
                    }
                }
                else if(B.charAt(i)=='?' || (B.charAt(i)==A.charAt(index))){
                    dpStore[a][b] =
                    isMatch(A, B, index+1, i+1);
                    return dpStore[a][b];
                }

            dpStore[a][b] = 0;
            return 0;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aabcdefg","a*?ef?*g"));
    }


}
