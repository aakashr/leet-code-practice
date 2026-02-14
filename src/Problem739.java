package src;

import java.util.Stack;

public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[][]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        pair(stack, temperatures[0], 0);
        for(int i=1;i<temperatures.length;i++) {
            int temp = temperatures[i];
            if (temp >= stack.peek()[0][0]) {
                while (!stack.isEmpty() && stack.peek()[0][0] < temp) {
                    int popIdx = stack.pop()[0][1];
                    res[popIdx] = i - popIdx;
                }
            }
            pair(stack, temperatures[i], i);
        }
        return res;
    }

    void pair(Stack<int[][]> stack, int temp, int index) {
        int[][] pair = new int[1][2];
        pair[0][0] = temp;
        pair[0][1] = index;
        stack.push(pair);
    }

    public static void main(String[] args) {
        Problem739 obj = new Problem739();

        int[] nums = new int[]{89,62,70,58,47,47,46,76,100,70};

        for(int n: obj.dailyTemperatures(nums)) {
            System.out.print(n + " ");
        }
    }
}
