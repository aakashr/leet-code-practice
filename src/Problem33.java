package src;

import java.util.Arrays;
import java.util.List;

public class Problem33 {
    public int search(int[] nums, int target) {
        int r=nums.length-1, l = 0;

        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem33 obj = new Problem33();
        int[] inputArr = {4,5,6,7,0,1,2};
        int[] intputTarget = {0, -100};
        String format = "Array: %s Target: %d Result: %d";

        for (int i=0;i<intputTarget.length;i++) {
            int result = obj.search(inputArr, intputTarget[i]);
            System.out.println(String.format(format, Arrays.toString(inputArr), intputTarget[i], result));
        }

    }

}
