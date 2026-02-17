package src;

import java.util.*;

public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<List<Integer>> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int n:nums) {
            map.putIfAbsent(n, 1);
            map.put(n, map.get(n) + 1);
        }

        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(-1 * entry.getValue());
            q.add(list);
        }
        for (int i=0; i<k;i++) {
            res[i] = q.poll().get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem347 obj = new Problem347();
        int[] nums = new int[]{1,2,2,3,3,3};
        System.out.println(obj.topKFrequent(nums, 3));
    }
}
