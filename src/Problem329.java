package src;


public class Problem329 {
    int maxPath = Integer.MIN_VALUE;
    int ROWS = 0, COLS=0;
    int[][] cache;
    int[][] dir = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        cache = new int[ROWS][COLS];

        for (int r=0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++) {
                maxPath = Math.max(maxPath, dfs(matrix, r,c, Integer.MIN_VALUE));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int r, int c, int prev) {
        if (r >= ROWS || c >= COLS || r < 0 || c < 0 || matrix[r][c] <= prev) {
            return 0;
        }

        if (cache[r][c] != 0) {
            return cache[r][c];
        }

        int curVal = matrix[r][c];
        for (int d[]: dir) {
            cache[r][c] = Math.max(cache[r][c], dfs(matrix, r+d[0], c+d[1], curVal));
        }

        return ++cache[r][c];
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9,9,4}, {6,6,8}, {2,1,1}};
        Problem329 obj =  new Problem329();
        System.out.println(obj.longestIncreasingPath(matrix) == 4);
    }
}
