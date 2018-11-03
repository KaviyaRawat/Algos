import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap2 {

    static String electionWinner(String[] votes) {
        Map<String, Integer> map = new HashMap<>();
        int size = votes.length, i;
        for (i=0; i<size; i++){
            if(map.get(votes[i])==null){
                map.put(votes[i], 1);
            }
            else{
                map.put(votes[i], map.get(votes[i])+1);
            }
        }

        Map<String, Integer> treeMap = new TreeMap<String, Integer>(new ComparatorMap(map));

        treeMap.putAll(map);
        final String[] result = new String[1];
        final int[] max = {0};
        treeMap.forEach((key,value)->{
            if(value>= max[0]){
                max[0] = value;
                result[0] = key;
            }
        });
        return result[0];
    }
    public static class ComparatorMap implements Comparator<String>{
        Map<String, Integer> map = new HashMap<>();
        public ComparatorMap(Map<String, Integer> map) {
            this.map = map;
        }

        @Override

        public int compare(String o1,  String o2) {
            if(map.get(o1).equals((map.get(o2)))){
                return o2.compareTo(o1);
            }
            return map.get(
                    o1).compareTo(map.get(
                    o2));
        }
    }
    public static void main(String[] args) {
        electionWinner(new String[]{"BB", "AA" ,"AA", "BB"});
    }

}
