package src;

import src.ToComplete.SortAlphaNumeric;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem1029 {
    public int twoCitySchedCost(int[][] costs) {
        List<List<Integer>> list = new ArrayList<>();

        for (int[] cost: costs) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(cost[1] - cost[0]);
            tempList.add(cost[0]);
            tempList.add(cost[1]);
            list.add(tempList);

        }
        list.sort(Comparator.comparingInt(List::getFirst));
        int sum = 0;
        for (int i = 0; i<list.size(); i++) {
            if (i<list.size()/2) {
                sum+= list.get(i).get(2);
            } else {
                sum+= list.get(i).get(1);
            }
        }
        return sum;
    }

    public void runTests(int[][][] testCases, int[] expected) {
        int tcNumber = 0;
        String format = "TC#-%d\tResult- %b";
        for (int[][] testCase: testCases) {
            boolean result = twoCitySchedCost(testCase) == expected[tcNumber++];
            System.out.println(String.format(format, tcNumber, result));
        }
    }

    public static void main(String[] args) {
        Problem1029 obj = new Problem1029();
        int[][][] testCases = {
                {{10,20},{30,200},{400,50},{30,20}},
                {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}
        };
        int[] expectedResult =  {110, 1859};
        obj.runTests(testCases, expectedResult);
    }
}
