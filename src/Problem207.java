package src;

import java.util.*;

public class Problem207 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i=0; i<=numCourses;i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preReqCourse = prerequisite[1];
            map.get(course).add(preReqCourse);
        }

        for (int n:map.keySet()) {
            if (!dfs(n)) return false;
        }
        return true;
    }

    boolean dfs(int cur) {
        if (visited.contains(cur)) {
            return false;
        }

        if (map.get(cur).isEmpty()) {
            return true;
        }
        visited.add(cur);

        for (int n:map.get(cur)) {
            if (!dfs(n)) {
                return false;
            }
        }
        visited.remove(cur);
        return true;
    }

    public static void main(String[] args) {
        Problem207 obj = new Problem207();
        // No Cycles
         int[][] nums = new int[][]{{0,1}, {0,2}, {1,2}};
        int num = 2;

        // Cycles
        //  int[][] nums = new int[][]{{0,1}, {1,0}};

        System.out.println(obj.canFinish(num, nums));
    }
}
