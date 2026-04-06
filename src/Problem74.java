package src;

public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        return binarySearch(matrix, target, 0, ROW*COL-1);

    }

    private boolean binarySearch(int[][] matrix, int target, int l, int r) {
        int COL = matrix[0].length;
        int mid = (l+r)/2;
        int midRow = mid / COL;
        int midCol = mid % COL;
        int midValue = matrix [midRow][midCol];

        if (target == midValue) {
            return true;
        }

        if (l >= r) {
            return false;
        }

        if (target < midValue) {
            return binarySearch(matrix, target, l, mid-1);
        } else {
            return binarySearch(matrix, target, mid+1, r);
        }

    }

    public static void main(String[] args) {
        Problem74 obj = new Problem74();
        // target doesn't exist
//         int[][] nums = new int[][]{{1, 1, 21}, {3, 3, 4}, {5, 5, 6}};

        // target exists
        int[][] nums = new int[][]{{1, 1, 2}, {3, 3, 4}, {5, 5, 6}};
        int target = 2;
        System.out.println(obj.searchMatrix(nums, target));
    }
}
