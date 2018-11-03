package jsr.interviewBit;

import java.util.ArrayList;

public class DPGridTraversal {


    public static class Solution {

        int[][] dpStore;
        int m;
        int n;

        public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
            if(A==null || A.size()==0 || A.get(n).get(m)==1){
                return 0;
            }

            m = A.size();
            n = A.get(0).size();
            dpStore = new int[m][n];

            return uniquePathsWithObstacles(A, 0, 0);

        }

        public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A, int x, int y){
            if(x==n || y==m){
                return 0;
            }
            if(x==n-1 && y==m-1){
                return 1;
            }
            if(dpStore[y][x]==0){

                if(y+1!=m && A.get(y+1).get(x)==0){
                    dpStore[y][x] =
                            uniquePathsWithObstacles(A, x, y+1);
                }

                if(x+1!=n && A.get(y).get(x+1)==0){
                    dpStore[y][x] = dpStore[y][x] +
                            uniquePathsWithObstacles(A, x+1, y);
                }
            }
            return dpStore[y][x];
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(0);

        list.add(list1);
        list.add(list1);

        System.out.println(new Solution().uniquePathsWithObstacles(list));

    }
}
