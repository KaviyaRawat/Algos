package jsr.gfg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class NQueens {

    public static class Solution {

        class Pr{
            int x;
            int y;
            public Pr(int xx, int yy){
                x=xx;
                y=yy;
            }
        }

        public ArrayList<ArrayList<String>> solveNQueens(int a) {
            return solveNQueens(a, 0, new HashSet<>(), new ArrayList<>());
        }

        public ArrayList<ArrayList<String>> solveNQueens(int a, int n, HashSet<Integer> column, List<Pr> diag){
            if(n>=a){
                return new ArrayList<>();
            }
            ArrayList<String> ans1 = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for(int i=0; i<a; i++){
                str.append(".");
            }
            ans1.add(str.toString());
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            ArrayList<ArrayList<String>> temp = new ArrayList<>();
            List<Pr> list = validPositions(a, n, column, diag);
            for (Pr pair : list) {
                ArrayList<String> ans2 = new ArrayList<>();
                ans2.add(0, ans1.get(0).substring(0, pair.y) + "Q" + ans1.get(0).substring(pair.y + 1));
                if(a-1>n) {
                    HashSet<Integer> column1 = new HashSet<>(column);
                    column1.add(pair.y);
                    List<Pr> diag1 = new ArrayList<>(diag);
                    diag1.add(pair);
                    for (ArrayList<String> st : solveNQueens(a, n + 1, column1, diag1)) {
                        ans = new ArrayList<>();
                        if (st.size() + n == a - 1) {
                            ArrayList<String> constt = new ArrayList<>(ans2);
                            constt.addAll(st);
                            ans.add(constt);
                        }
                    }
                }
                else{
                    ans.add(ans2);
                }
            }

            return ans;
            }

            public ArrayList<Pr> validPositions(int a, int n,  HashSet<Integer> column, List<Pr> diag){
                ArrayList<Pr> list = new ArrayList<>();
                for(int i=0; i<a; i++){
                    if(!column.contains(i)){
                        if(notOnDiag(n, i, diag)){
                            list.add(new Pr(n, i));
                        }
                    }
                }
                return list;
            }

        public boolean notOnDiag(int n, int i, List<Pr> diag){
            for(int j=0; j<diag.size(); j++){
                if(n-diag.get(j).x == i-diag.get(j).y){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(2));
    }

}
