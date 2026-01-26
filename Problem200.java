import java.util.*;


public class Problem200 {

    private Set<String> visited = new HashSet<>();
    private int islands = 0;
    private int totalRows = 0;
    private int totalCols = 0;
    private static final int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};


    private int numIslands(char[][] grid) {
        totalRows = grid.length;
        totalCols = grid[0].length;
        for (int r=0; r< grid.length; r++) {
            for (int c=0; c< grid[r].length; c++) {
                if (grid[r][c] == '1' && !isVisited(visited, r, c)) {
                    bfs(r, c, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(int r, int c, char[][] grid) {
        Queue<KeyValuePair> queue = new ArrayDeque<>();
        KeyValuePair currentVal = new KeyValuePair(r, c);
        visited.add(r + " " + c);
        queue.add(currentVal);

        while (!queue.isEmpty()) {
            KeyValuePair qVal = queue.poll();
            for (int[] direction: DIRECTIONS) {
                int row = qVal.key + direction[0];
                int col = qVal.value + direction[1];
                if (row < totalRows && col < totalCols && row >= 0 && col >= 0
                        && grid[row][col] == '1' && !visited.contains(row + " " + col)) {
                    KeyValuePair curKeyVal = new KeyValuePair(row, col);
                    queue.add(curKeyVal);
                    visited.add(curKeyVal.key + " " + curKeyVal.value);
                }
            }
        }
    }

    private static boolean isVisited(Set<String> visited, int r, int c) {
        if (visited.contains(r + " " + c)) {
                return true;
            }
        return false;
    }

    static class KeyValuePair {
        private Integer key;
        private Integer value;

        public KeyValuePair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        // Optional: Override toString for better printing
        @Override
        public String toString() {
            return '(' + key + ", " + value + ')';
        }
    }

    public static void main(String[] args) {
//        char[][] my2DArray = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] my2DArray = {{'1'}};
        System.out.println(new Problem200().numIslands(my2DArray));
    }
}

// null, 1, 2, 3
// cur = null, prev = null, next = 1
// 1, null, 2, 3
// cur = null, prev = 1, next = 2
// null, 2, 1, 3

