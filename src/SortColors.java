import java.util.Scanner;

public class SortColors {

    public class Book{
        Color color;
    }

    enum Color{
        Red,
        Blue,
        Green;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] array = new String[n];

        for(int i=0; i<n; i++){
            array[i] = in.next();
        }
        int j = n-1;
        int i = 0;
        String left = array[0];
        String right = null;
        i= partition(array, i, j, left);
        /*if(i+1!=n-1){
            left = array[i+1];
            right = array[n-1];
            j = n-1;
            i = partition(array, i+1, j, left);
        }*/

        for(i=0; i<n; i++) {
            System.out.println(array[i]);
        }

    }

    private static int partition(String[] array, int i, int j, String left){
        while(i<=j){
            while(array[i].equals(left)){
                i++;
            }
            while(!array[j].equals(left)){
                j--;
            }
            swap(array, i, j);
        }
        return i;
    }

    private static void swap(String[] array, int j, int i) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
