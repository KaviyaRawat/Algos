public class AlphabeticallyGreater {
    /*
    * Complete the function below.
    */
    static String rearrangeWord(String word) {
        char[] charWord = word.toCharArray();
        boolean found = false;
        for(int i=word.length()-1; i>0; i--){
            if(charWord[i]==charWord[i-1] || charWord[i-1]>charWord[i]){
                continue;
            }
            else{
                char temp = charWord[i-1];
                charWord[i-1] = charWord[i];
                charWord[i] = temp;
                found = true;
                break;
            }
        }
        if(found){
            return new String(charWord);
        }
        else{
            return "no answer";
        }
    }

    public static void main(String[] args) {
        System.out.println(rearrangeWord("gfg"));
    }
}
