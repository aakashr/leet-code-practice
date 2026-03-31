package src;

import java.util.*;

public class Problem853 {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> stack = new Stack<Float>();

        int[][] posSpeed = new int[position.length][2];

        for(int i=0;i<position.length;i++) {
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }

        Arrays.sort(posSpeed, (a, b) -> Integer.compare(a[0], b[0]));


        float timeToDest = (target - posSpeed[posSpeed.length-1][0])/(float) posSpeed[posSpeed.length-1][1];
        stack.push(timeToDest);

        for(int i=posSpeed.length-2;i>=0;i--) {
            float curDist = posSpeed[i][0];
            float curSpeed = posSpeed[i][1];

            timeToDest = (target - curDist)/curSpeed;
            float peekTimeToDest = stack.peek();

            if (timeToDest > peekTimeToDest) {
                stack.push(timeToDest);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        Problem853 obj = new Problem853();
        int[][] pos = new int[][]{{1,4}, {4,1,0,7}, {6,8}};
        int[][] speed = new int[][]{{3,2}, {2,2,1,1}, {3,2}};
        int target = 10;

        int[] result = new int[] {1, 3, 2};


        for (int i=0; i< pos.length;i++) {
            String format = "Positions: %s Speeds: %s Target: %d - Result: %s";
            boolean actualResult = obj.carFleet(target, pos[i], speed[i]) == result[i];
            System.out.println(String.format(format, (Arrays.toString(pos[i])), Arrays.toString(speed[i]), target, actualResult));

        }


    }
}
