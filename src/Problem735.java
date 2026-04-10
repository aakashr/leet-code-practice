package src;

import java.util.Arrays;
import java.util.Stack;

public class Problem735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        if (asteroids.length == 1) {
            return new int[] {asteroids[0]};
        }

        int i = 1;
        stack.push(asteroids[0]);

        while(i < asteroids.length) {
            int cur = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(cur);
                i++;
                continue;
            }
            int peek = stack.peek();
            int product = peek * cur;

            if (product > 0) {
                stack.push(cur);
                i++;
            } else {
                if (cur > 0) {
                    stack.push(cur);
                    i++;
                } else {
                    if (Math.abs(cur) == Math.abs(peek)) {
                        stack.pop();
                        i++;
                    } else {
                        // Current is bigger - Pop peek
                        if (Math.abs(cur) > peek) {
                            stack.pop();
                            // Current is smaller - ignore current.
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            int[] result = new int[stack.size()];
            int j = stack.size()-1;
            while (!stack.isEmpty()) {
                result[j--] = stack.pop();
            }
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Problem735 obj = new Problem735();
        int[][] inputs = {{5,10,-5}, {8,-8}, {10,2,-5}, {3,5,-6,2,-1,4}};

        for (int i=0;i< inputs.length;i++) {
            String format = "Input: %s output: %s";
            System.out.println(String.format(format, Arrays.toString(inputs[i]), Arrays.toString(obj.asteroidCollision(inputs[i]))));
        }
    }
}
