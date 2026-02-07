package src;

public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int top = 0, bottom = ROWS - 1, midROW=0;

        while (top <= bottom) {
            midROW = (top + bottom)/2;
            if (target > matrix[midROW][COLS - 1]) {
                top = midROW + 1;
            } else if (target < matrix[midROW][0]) {
                bottom = midROW - 1;
            } else {
                break;
            }
        }

        int l = 0, r = COLS - 1;

        while (l <= r) {
            int midCOL = (l + r) / 2;

            if (target > matrix[midROW][midCOL]) {
                l = midCOL + 1;
            } else if (target < matrix[midROW][midCOL]) {
                r = midCOL - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem74 obj = new Problem74();
        // target doesn't exist
        // int[][] nums = new int[][]{{1, 1, 21}, {3, 3, 4}, {5, 5, 6}};

        // target exists
        int[][] nums = new int[][]{{1, 1, 2}, {3, 3, 4}, {5, 5, 6}};
        int target = 2;
        System.out.println(obj.searchMatrix(nums, target));
    }
}
