package jsr.interviewBit;

import java.util.*;

public class LongestPath {
    public static class Solution {

        class Node {
            int depth;
            int node;
            public Node(int d, int n){
                depth =d;
                node = n;
            }
        }

        public int solve(List<Integer> A) {
            if(A==null || A.size()==1){
                return 0;
            }
            HashMap<Integer, ArrayList<Integer>> graph = createGraph(A);

            Node ans1 = bfs(graph, 0);

            Node ans2 = bfs(graph, ans1.node);

            return ans2.depth;
        }

        HashMap<Integer, ArrayList<Integer>> createGraph(List<Integer> A){
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i=0; i<A.size(); i++){
                if(A.get(i)>=0){
                    if(map.get(A.get(i))==null){
                        map.put(A.get(i), new ArrayList<>());
                    }
                    map.get(A.get(i)).add(i);
                    if(map.get(i)==null){
                        map.put(i, new ArrayList<>());
                    }
                    map.get(i).add(A.get(i));
                }

            }
            return map;
        }


        Node bfs(HashMap<Integer, ArrayList<Integer>> graph, int i){
            int[] visited = new int[graph.size()];
            Queue<Node> q  = new LinkedList<>();
            Node n = new Node(0, i);
            q.add(n);

            Node ansNode = n;
            while(!q.isEmpty()){
                n = q.poll();
                if(n.depth>ansNode.depth){
                    ansNode = n;
                }
                if(visited[n.node]==0){
                    ArrayList<Integer> list = graph.get(n.node);

                    if(list!=null){

                        int[] dp = {n.depth};

                        list.forEach(nd ->{
                            if(visited[nd]==0){
                                q.add(new Node( dp[0]+1,nd));
                            }
                        });

                    }

                    visited[n.node] = 1;
                }
            }
            return ansNode;

        }





    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve(Arrays.asList((Integer[]) new Integer[]{-1, 0})));
    }
}
