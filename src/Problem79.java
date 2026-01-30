package src;

public class Problem79 {
    private char[][] myBoard;
    private String myWord;
    private int rCount, cCount;

    public boolean exist(char[][] board, String word) {
        myBoard = board;
        myWord = word;
        rCount = board.length;
        cCount = board[0].length;
        for (int r=0;r<board.length;r++) {
            for (int c=0;c<board[0].length;c++) {
                boolean res = findMatch(board, 0, r, c);
                if (res) {
                    return res;
                }
            }
        }
        return false;
    }

    public boolean findMatch(char[][] board, int idx, int r, int c) {
        if (r >= rCount || c >= cCount || r < 0 || c < 0 || myBoard[r][c] == '1') {
            return false;
        }

        if (myWord.length() -1 == idx && myBoard[r][c] == myWord.charAt(idx)) {
            return true;
        }

        char cur = myWord.charAt(idx);
        if (myBoard[r][c] == cur) {
            myBoard[r][c] = '1';
            boolean res = findMatch(myBoard, idx+1, r+1, c) ||
                    findMatch(myBoard, idx+1, r, c+1) ||
                    findMatch(myBoard, idx+1, r-1, c) ||
                    findMatch(myBoard, idx+1, r, c-1);
            myBoard[r][c] = cur;
            return res;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Problem79 obj = new Problem79();

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        // Word exists
        String word = "SEE";

        // Word doesn't exist
        // String word = "SAW";
        System.out.println(obj.exist(board, word));
    }
}
