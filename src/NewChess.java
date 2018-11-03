
import java.util.*;

public class NewChess {
    private static int[] yy = {-1, 1, 2, 1, -1, -2};
    private static int[] xx = {-2, -2, 0, 2, 2, 0};
    private static String[] move = {"UL", "UR", "R", "LR", "LL", "L"};
    private static boolean answerFound = false;

    private static Queue<Answer> queue = new LinkedList<>();
    private static boolean[][] boardVisited;

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.
        queue.add(new Answer(i_start, j_start, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Answer pair = queue.poll();
            boardVisited[pair.x][pair.y] = true;
            if (pair.x == i_end && pair.y== j_end) {
                System.out.println(pair.answer.size());
                System.out.print(pair.answer.get(0));
                for (int j = 1; j < pair.answer.size(); j++) {
                    System.out.print(" " + pair.answer.get(j));
                }
                return;
            }

            for (int i = 0; i < 6; i++) {
                int newX = pair.x + xx[i];
                int newY = pair.y + yy[i];
                List<String> list = new ArrayList(pair.answer);
                if (isValidMove(newX, newY, n) && !boardVisited[newX][newY]) {

                    list.add(move[i]);
                    queue.add(new Answer(newX, newY, list));

                }
            }

        }

        System.out.println("Impossible");
    }

    static boolean isValidMove(int x, int y, int n) {
        if (x < 0 || y < 0) {
            return false;
        } else if (x >= n || y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        // added this
        boardVisited = new boolean[n][n];
        printShortestPath(n, i_start, j_start, i_end, j_end);

        in.close();
    }


    static class Answer {
        private int x;
        private int y;

        public Answer(int x, int y, List<String> answer) {
            this.x = x;
            this.y = y;
            this.answer = answer;
        }

        private List<String> answer;
    }
}
