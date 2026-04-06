package src;

import java.util.Stack;

public class Problem84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> indexHeight = new Stack<>();
        indexHeight.push(new int[]{0, heights[0]});
        for (int i=1;i<heights.length;i++) {
            int curHeight = heights[i];
            if (!indexHeight.isEmpty() && curHeight >= indexHeight.peek()[1]) {
                indexHeight.push(new int[]{i, curHeight});
            } else {
                int index = i;
                while(!indexHeight.isEmpty() && curHeight < indexHeight.peek()[1]) {
                    int[] pop = indexHeight.pop();
                    int height = pop[1];
                    index = pop[0];
                    maxArea = Math.max(maxArea, height * (i-index));
                }
                int pushIndex = i!=index ? index:i;
                indexHeight.push( new int[] {pushIndex, curHeight});
            }
        }

        while (!indexHeight.isEmpty()) {
            int[] pop = indexHeight.pop();
            int height = pop[1];
            int index = pop[0];
            maxArea = Math.max(maxArea, height * ((heights.length)-index));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Problem84 obj = new Problem84();
        System.out.println(obj.largestRectangleArea(new int[] {2,4}));
    }
}
