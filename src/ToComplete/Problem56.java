package src.ToComplete;

import src.Problem253;

import java.util.ArrayList;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        int start = intervals[0][0];
        int end = intervals[0][1];
        int[][] result = new int[intervals.length][2];
        int p=0;
        for (int i=1; i<intervals.length;i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curStart <= end) {
                List<Integer> temp = new ArrayList<>();
                int e = end > curEnd ? end : curEnd;
                result[p][0] = start;
                result[p][1] = e;
                end = e;
                p++;
            } else {
                result[p][0] = curStart;
                result[p][1] = curEnd;
                start = curStart;
                end = curEnd;
                p++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Problem56 obj = new Problem56();
        int[][] nums = new int[][]{{2,10},{4,10},{10,20},{10,30}};
        System.out.println(obj.merge(nums));
    }

}
