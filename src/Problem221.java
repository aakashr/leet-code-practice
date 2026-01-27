package src;

import java.util.HashMap;

public class Problem221 {

    public int maximalSquare(char[][] matrix) {
        HashMap<String, Integer> seenMap = new HashMap<>();

        helper(0, 0, matrix, seenMap);

        int max = seenMap.get(0 + " " + 0);
        for (int val:seenMap.values()) {
            max = Math.max(max, val);
        }

        return max;
    }

    private int helper(int r, int c, char[][] matrix, HashMap<String, Integer> seenMap) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        if (r >= ROWS || c >= COLS) {
            return 0;
        }
        String key = r + " " + c;
        if (!seenMap.containsKey(key)) {
            int right = helper(r, c+1, matrix, seenMap);
            int down = helper(r+1, c, matrix, seenMap);
            int diagonal = helper(r+1, c+1, matrix, seenMap);

            seenMap.put(key, 0);

            int min = Math.min(right, down);
            min = Math.min(min, diagonal);

            if (matrix[r][c] == '1') {
                seenMap.put(key, 1 + min);
            }
        }


        return seenMap.get(key);
    }
    public static void main(String[] args) {
        Problem221 obj = new Problem221();
        char[][] matrix = new char[][] {{'1','0','1','0', '0'}, {'1','0','1','1', '1'}, {'1','1','1','1', '1'}, {'1','0','0','1', '0'}};

        int result = obj.maximalSquare(matrix);

        System.out.println(result * result);
    }

}
