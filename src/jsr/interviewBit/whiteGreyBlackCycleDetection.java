package jsr.interviewBit;

import java.util.ArrayList;

public class whiteGreyBlackCycleDetection{

    int[] visited;
    public int solve(int A, int[] B, int[] C) {
        if(A==1){
            return 1;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<A; i++){
            graph.add(i, new ArrayList<>());
        }
        for(int i=0; i<B.length; i++){
            graph.get(B[i]).add(C[i]);
        }
        visited = new int[A];
        for(int i=0; i<A; i++){
            visited[i] = -1;
        }
        int N = A;
        for(int i=0; i<N; i++){
            int value = traversal(graph,i);
            if(value==-1)
                return 0;
        }
        return 1;

    }

    public int traversal(ArrayList<ArrayList<Integer>> graph, int k){
        if(visited[k]==1){
            return 1;
        }

        if(visited[k]==-1){
            visited[k] = 0;
            final boolean[] returnValue = {false};
            for(int j=1; j<graph.get(0).size(); j++){
                graph.get(k).forEach(id ->{
                    int value =  traversal(graph, id);
                    if(value == -1){
                        returnValue[0] = true;
                    }
                });
            }
            if(returnValue[0]){
                return -1;
            }
            visited[k] = 1;
        }
        else {
            return -1;
        }
        return 1;
    }
}
