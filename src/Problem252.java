package src;

import java.util.Arrays;

public class Problem252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals.length == 0) {
            return true;
        }
        int prevEnd = intervals[0][1];
        for (int i=1;i<intervals.length;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < prevEnd) {
                return false;
            } else {
                prevEnd= end;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        Problem252 obj = new Problem252();
        // Cannot attend
        int[][] nums = new int[][]{{0,30},{5,10},{15,20}};
        // Can attend
//        int[][] nums = new int[][]{{7,10},{2,4}};
        System.out.println(obj.canAttendMeetings(nums));
    }
}
