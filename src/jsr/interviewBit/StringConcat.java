package jsr.interviewBit;

import java.util.*;

public class StringConcat {


    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> findSubstring(String A, final List<String> B) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            HashMap<String, Integer> set = new HashMap<>();
            HashMap<String, Integer>  setCopy = new HashMap<>();
            if(B==null || B.size()==0){
                return list;
            }
            for(int i=0; i<B.size(); i++){
                if(set.get(B.get(i))!=null){
                    set.put(B.get(i), set.get(B.get(i))+1);
                }
                else{
                    set.put(B.get(i), 1);
                }
            }
            // size of each word
            int N = B.get(0).length();
            // number of words in B
            int M = B.size();
            int count;
            for(int j=0; j<N; j++){
                setCopy = new HashMap<>(set);
                for(int m =j; m+N<=A.length(); m=m+N){

                        int index = (m + N) - (M * N);
                        String str = A.substring(m, m+N);
                        if(setCopy.get(str)!=null){

                            setCopy.put(str, setCopy.get(str)-1);

                            if(checkIfAllZero(setCopy)){
                                list.add(index);
                            }
                        }
                        if((m+N)-(M*N)>=0) {
                            if(setCopy.get(A.substring(index, index + N))!=null) {
                                setCopy.put(A.substring(index, index + N), setCopy.get(
                                        A.substring(index, index + N)) + 1);
                            }
                        }

                }
            }
            Collections.sort(list);
            return list;

        }

        private boolean checkIfAllZero(HashMap<String, Integer> setCopy) {

            for(Map.Entry<String, Integer> entry: setCopy.entrySet()){
                if(entry.getValue()!=0) {
                    return false;
                }
            }

            return true;
        }
    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("cac");
        list.add("aaa");
        list.add("aab");
        list.add("aba");
        list.add("abc");
        System.out.println(new Solution().findSubstring("abaaaabcaabcacabaa",
                list));
    }

}
