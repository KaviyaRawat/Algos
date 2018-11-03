package jsr.interviewBit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ValidSoduko {
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int isValidSudoku(final List<String> A) {
            HashMap<Integer, HashSet<Character>> map1 = new HashMap<>();
            HashMap<Integer,  HashSet<Character>> mapV = new HashMap<>();
            HashSet<Character> mapH = new HashSet<>();

            for(int i=0; i<3; i++){
                int count=0;
                map1 = new HashMap<>();
                while(count<3){
                    int k = i*3+count;
                    String str = A.get(k);

                    for(int j=0; j<9; j++){
                        // Horizontal Correctness
                        if(str.charAt(j)!='.') {
                            if (mapH.contains(str.charAt(j)))
                                return 0;
                            mapH.add(str.charAt(j));
                            // Vertical Correctness
                            if (mapV.get(j) != null && mapV.get(j).contains(str.charAt(j)))
                                return 0;
                            if (mapV.get(j) == null) {
                                mapV.put(j, new HashSet());
                            }
                            mapV.get(j).add(str.charAt(j));
                            // Square Correctness Check Here

                            if (map1.get(j / 3) != null && map1.get(j / 3).contains(str.charAt(j))) {
                                return 0;
                            }
                            if (map1.get(j / 3) == null) {
                                map1.put(j / 3, new HashSet());
                            }
                            map1.get(j / 3).add(str.charAt(j));
                        }
                    }
                    mapH = new HashSet<>();
                    count ++;
                }
                count=0;

            }

            return 1;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(Arrays.asList("..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6..")));
    }
}
