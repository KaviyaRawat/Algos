package jsr.interviewBit;

import java.util.*;

public class Trie {
    public static class Solution {

        class Node{

            HashMap<Character, Node> list = new HashMap<>();
            String word;

            Node(String str){
                word = str;
            }

            Node(){

            }


        }
        public ArrayList<String> prefix(List<String> A) {

            Node root = new Node();
            Node n1 = new Node(A.get(0));
            root.list.put(A.get(0).charAt(0), n1);

            for(int i=1; i<A.size(); i++){
                String word = A.get(i);
                Node temp = root;
                int j=0;
                Node prev = temp;
                String word1="";
                while(temp.list.get(word.charAt(j))!=null){
                    prev = temp;
                    temp = temp.list.get(word.charAt(j));
                    word1 = temp.word;
                    j++;
                }
                int start = j;
                while(word1!=null && word1!=""
                        && j<word1.length()
                        && j<word.length()
                        && word1.charAt(j)==word.charAt(j)){
                    j++;
                }

                while(start<j){
                    Node n2 = new Node();
                    temp.list.put(word.charAt(start), n2);
                    temp = n2;
                    start++;
                }
                Node n2 = new Node(word);
                temp.list.put(word.charAt(j), n2);
                if(word1!=null && word1!="") {
                    n2 = new Node(word1);
                    temp.list.put(word1.charAt(j), n2);
                }

            }

            ArrayList<String> jsr2 = traverseTrie(root);

            return jsr2;
        }

        private ArrayList<String> traverseTrie(Node root) {
            ArrayList<String> jsr2 = new ArrayList<>();
            if(root.list.size()==0){
                return jsr2;
            }
            root.list.forEach((key,node) -> {
                ArrayList<String> lst = traverseTrie(node);
                for (String s : lst) {
                    jsr2.add(key+s);
                }
                if(lst.size()==0){
                    jsr2.add(key.toString());
                }
            });
            return jsr2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().prefix((java.util.List)(Arrays.asList("abcdefgv", "abcdefgrr", "abcdefglj", "abcdefgtnsnfwzqfj", "abcdefafadr", "abcdefgwsofsbcnuv", "abcdefghffbsaq", "abcdefgwp", "abcdefgcb", "abcdefgcehch"))));
    }

}
