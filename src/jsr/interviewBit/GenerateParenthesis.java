package jsr.interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GenerateParenthesis {

    static HashMap<Integer, ArrayList<String>> map = new HashMap<>();
    static boolean[][] visited;

    public static class Solution {
        public ArrayList<String> generateParenthesis(int A) {
        visited = new boolean [A][A];

            HashSet<String> hs = new HashSet<>();
            hs.addAll(genPrnths(A, 0));
            ArrayList<String> ls = new ArrayList<>();
            ls.addAll(hs);
            return ls;
        }


        public ArrayList<String> genPrnths(int A, int count){
            ArrayList<String> list = new ArrayList<>();

            /*if(visited[A][count]){
                    return list;
            }
            visited[A-1][count-1] = true;*/

            if(map.get(A)!=null && count==0){
                return map.get(A);
            }

            if(A==0){
                StringBuilder jsr = new StringBuilder();
                while(count-->0){
                    jsr.append(")");
                }
                list.add(jsr.toString());
                return list;
            }


            genPrnths(A-1, count+1).forEach(str->{
                list.add("("+str);
            });

            StringBuilder jsr = new StringBuilder();
            if(count==0)
                map.put(A, list);
            while(count>0){
                jsr.append(")");
                count--;
                genPrnths(A, count).forEach(str->{
                    list.add(jsr.toString() + str);
                });
            }


            return list;


        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

}
