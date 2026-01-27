package src;

import java.util.Arrays;

public class MeetingIntervalRemoval {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals[0][0];
    }
    public static void main(String[] args) {
        MeetingIntervalRemoval obj = new MeetingIntervalRemoval();
        // int[][] nums = new int[][]{{0, 30}, {5, 10}, {15, 20}};
//        int[][] nums = new int[][]{{8, 9}, {8, 9}, {1, 5}};
//        int[][] nums = new int[][]{{7, 10}, {2, 4}};
        int[][] nums = new int[][]{{2,10},{4,10},{10,20},{10,30}};
        System.out.println(obj.eraseOverlapIntervals(nums));
    }
}
