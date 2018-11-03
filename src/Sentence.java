import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sentence {

    /*
   * Complete the function below.
   */
    static String arrange(String sentence) {
        String[] words = sentence.split(" ");
        int length = words.length;
        words[length-1] = words[length-1].substring(0, words[length-1].length()-1);
        List<MyString> list = new ArrayList<>();
        for(int i =0; i<words.length; i++){
            MyString str = new MyString(words[i]);
            list.add(str);
        }

        Collections.sort(list);
        String first = list.get(0).str;

            String capital = first.substring(0, 1).toUpperCase() + first.substring(1);

String answer = capital + " ";

        for(int i =1; i<words.length; i++){
            String word = list.get(i).str.substring(0, 1).toLowerCase() + list.get(i).str.substring(1);
            answer = answer + word + " ";
        }
        answer = answer.substring(0, answer.length()-1) + ".";
return answer;

    }

    public static class MyString implements Comparable<MyString> {
        String str;

        public MyString(String str) {
            this.str = str;
        }


        @Override
        public int compareTo(MyString o) {
            return this.str.length() - o.str.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(arrange("Jai Sai Ram how to make it work. "));
    }

}
