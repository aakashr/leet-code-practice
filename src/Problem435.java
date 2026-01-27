package src;

import java.util.Arrays;

public class Problem435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int result = 0;
        for (int i=1; i<intervals.length;i++) {

            // Meetings 1 and 2 end at same time. Not overlapping.
            // Meeting 2 ends after meeting 1. Not overlapping.
            // Meeting 2 start before meeting 1 ends. Overlapping.
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                result++;
                prevEnd = Math.min(end, prevEnd);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Problem435 obj = new Problem435();
//        TC1: Non overlapping meeting
//        int[][] nums = new int[][]{{1,2}, {3,4}};

//        TC2: Overlapping Meetings TC
        int[][] nums = new int[][]{{0,2}, {1,3}, {2,4}, {3,5}, {4,6}};
        System.out.println(obj.eraseOverlapIntervals(nums));
    }
}
