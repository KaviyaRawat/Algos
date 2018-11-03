/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;*/

//import for Scanner and other utility classes
import java.util.*;


class countZeros {

    private static int count2 = 0;
    private static int count5 = 0;
    private static int count10 = 0;

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        ArrayList<Integer> m = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int j=0; j<n; j++){
            int x = in.nextInt();
            m.add(x);
            max = Math.max(max,x);
        }
        int count=0, num=0;
        List<Integer> list;
        while(count<max+1){
            count = countZeros(num);
            if(map.get(count)==null){
                list = new ArrayList<>();
            }
            else{
                list = map.get(count);
            }
            list.add(num);
            map.put(count, list);
            num++;
        }
        for(int j=0; j<n; j++){
            list = map.get(m.get(j));
            if(list!=null)
                for(int i=0; i<list.size(); i++){System.out.print(list.get(i) + " ");}
        }
    }
    public static int countZeros(int num){

        int temp = num;
        while(temp%2==0 && temp!=0){
            count2++;
            temp = temp/2;
        }
        temp = num;
        while(temp%5==0 && temp!=0){
            count5++;
            temp = temp/5;
        }

        while(count2>0 && count5>0){
            count2--;
            count5--;
            count10++;
        }

        return count10;

    }
}
