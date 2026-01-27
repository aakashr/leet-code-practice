package src;

import java.util.*;

public class Problem253 {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> curScheduled = new ArrayList<>();
//        Set<Integer> curScheduled = new HashSet<>();
        int j = 0, meetRooms=0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i=0; i<intervals.length;i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][0];
            if (isRoomNeeded(curScheduled, startTime, endTime)) {
                meetRooms++;
                curScheduled.add(endTime);
            }
        }
        return meetRooms;
    }

    private boolean isRoomNeeded(List<Integer> curScheduled, int startTime, int endTime) {
        int i = 0;
        for (int n: curScheduled) {
            if (startTime >= n) {
                curScheduled.set(i, endTime);
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem253 obj = new Problem253();
        // int[][] nums = new int[][]{{0, 30}, {5, 10}, {15, 20}};
//        int[][] nums = new int[][]{{8, 9}, {8, 9}, {1, 5}};
//        int[][] nums = new int[][]{{7, 10}, {2, 4}};
        int[][] nums = new int[][]{{2,10},{4,10},{10,20},{10,30}};
        System.out.println(obj.minMeetingRooms(nums));
    }
}
