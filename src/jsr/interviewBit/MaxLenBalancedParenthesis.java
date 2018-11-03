package jsr.interviewBit;

import java.util.Stack;

public class MaxLenBalancedParenthesis {
        public int longestValidParentheses(String A) {
            Stack<Integer> s = new Stack();
            int max = 0;
            int start;
            for(start=0; start<A.length(); start++){
                if(A.charAt(start)=='('){
                    s.push(start);
                }else{
                    if(!s.isEmpty() && A.charAt(s.peek())=='('){
                        s.pop();
                    }
                    else{
                        s.push(start);
                    }
                }
            }if(s.isEmpty()){
                return A.length();
            }
            int b, a = A.length();
            while(!s.isEmpty()){
                b = s.pop();
                max =  Math.max(max, a-b-1);
                a=b;
            }
            max =  Math.max(max, a);
            return max;
        }

    public static void main(String[] args) {
        System.out.println(new MaxLenBalancedParenthesis().longestValidParentheses("(()))((((((())(()))()()(()()())(()(()))(())))((()(((((()()))())(())()()()))((())()())())()"));
    }


}
