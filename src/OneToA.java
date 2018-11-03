import java.util.HashMap;
import java.util.Scanner;

public class OneToA {


    private static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        for(int i=0; i<26; i++){
            map.put(i+1, String.valueOf((char)('A' + i)));
        }
        String num = in.next();
        printPossibleValue(num, "");
    }

    private static void printPossibleValue(String num, String strToBePrinted){
        String str = String.valueOf(num);  //.toCharArray();

        if(str.length()==0) {
            System.out.println(strToBePrinted);
            return;
        }
        if(str.substring(0,1).equals("0")){
            return;
        }
        if(str.length()>=2) {
            if (str.substring(0, 1).equals("1")) {
                String string = strToBePrinted + map.get(Integer.valueOf(str.substring(0, 2)));
                printPossibleValue(str.substring(2), string);
            }
            if (str.substring(0, 1).equals("2") && (Integer.valueOf(str.substring(1, 2)) <= 6)) {
                String string = strToBePrinted + map.get(Integer.valueOf(str.substring(0, 2)));
                printPossibleValue(str.substring(2), string);
            }
        }

            String string = strToBePrinted + map.get(Integer.valueOf(str.substring(0,1)));
            printPossibleValue(str.substring(1), string);


    }

}
