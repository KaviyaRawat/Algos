package jsr.interviewBit;

import java.util.ArrayList;

public class PrettyJson {


    public ArrayList<String> prettyJSON(String A) {
        //String[] array = A.split(",");
        ArrayList<String> list = new ArrayList<>();
        String  tabString = "";
        int tabCount = 0;
        String bigString = "";
        for(int j=0; j<A.length(); j++){
            char str = A.charAt(j);
            if(str == ','){
                bigString +=str;
                list.add(tabString + str);
                bigString = "";
            }
            else if(str == '{' || str == '['){
                if(!bigString.equals("")){
                    list.add(tabString + str);
                    bigString = "";
                }
                list.add(tabString+str);
                tabString += "\t";

            }
            else if(str== '}' || str == ']'){
                if(!bigString.equals("")){
                    list.add(tabString + str);
                    bigString = "";
                }
                tabString = tabString.substring(0, tabString.length()-1);
                list.add(tabString+str);
            }
            else{
                bigString +=str;
            }


        }

        return list;

    }

    public static void main(String[] args) {




    }


}
