package jsr.interviewBit;

import java.util.ArrayList;
import java.util.HashMap;

public class FindLongestPathTree {



    public class Solution {

        public class LeafNodeDepth{
            int node;
            int depth;
        }

        public int solve(ArrayList<Integer> A) {

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            int rootIndex = -1;
            for(int i=0; i<A.size(); i++){
                if(A.get(i)==-1){
                    rootIndex = i;
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    if(map.get(A.get(i))!=null){
                        list = map.get(A.get(i));
                    }
                    list.add(i);
                    map.put(A.get(i), list);
                    // undirected graph
                    list = new ArrayList<>();
                    if(map.get(i)!=null){
                        list = map.get(i);
                    }
                    list.add(A.get(i));
                    map.put(i, list);
                }
            }
            if(rootIndex==-1){
                return 0;
            }

            int[] visited = new int[A.size()];

            LeafNodeDepth leaf
                    = findDepth(map, rootIndex, visited);
            visited = new int[A.size()];
            leaf = findDepth(map, leaf.node, visited);

            return leaf.depth;
        }

    /*public int
    findMaxAndSecondMax(HashMap<Integer, ArrayList<Integer>> map, int root){

        int max = 0;
        int secondMax = 0;

        if(map.get(root)==null){
            return 0;
        }
        for(int i=0; i< map.get(root).size(); i++){
            int child = map.get(root).get(i);
            int depth = findDepth(map, child)+1;
                if(max<depth){
                    secondMax = max;
                    max = depth;
                }
                else if(secondMax<depth){
                    secondMax = depth;
                }
        }

        return max + secondMax;

    }*/



        public LeafNodeDepth
        findDepth(HashMap<Integer, ArrayList<Integer>> map, int root, int[] visited){
            LeafNodeDepth  leaf = new LeafNodeDepth();

            visited[root] = 1;
            int max = 0;
            int node = root;

            leaf.depth = max;
            leaf.node = node;
            if(map.get(root)!=null){
                for(int i=0; i<map.get(root).size(); i++){
                    int child = map.get(root).get(i);
                    if(visited[child]==0){
                        LeafNodeDepth  leaf1
                                = findDepth(map, child, visited);
                        if(leaf1.depth+1>max){
                            max = leaf1.depth+1;
                            node = leaf1.node;
                        }
                    }
                }
            }

            leaf.depth = max;
            leaf.node = node;

            return leaf;
        }

    }

    public static void main(String[] args) {

    }


}
