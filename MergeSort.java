import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {

    private static void mergeSort(int[] nums) {
        int len = nums.length;
        int mid = len/2;

        if (len < 2) {
            return;
        }

        int[] leftArr = new int[mid];
        int[] rightArr = new int[len - mid];

        for (int i=0; i<mid; i++) {
            leftArr[i] = nums[i];
        }

        for (int i=mid; i<len; i++) {
            rightArr[i-mid] = nums[i];
        }

        System.out.println(printArr(leftArr));
        System.out.println(printArr(rightArr));

        mergeSort(leftArr);
        mergeSort(rightArr);

        System.out.println("Starting Sorting!");


        merge(nums, leftArr, rightArr);
    }

    public static void merge(int[] nums, int[] leftArr, int[] rightArr) {
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        int l=0, r=0, k=0;

        while(l<leftSize && r<rightSize) {
            if (leftArr[l] <= rightArr[r]) {
                nums[k] = leftArr[l];
                l++;
            } else {
                nums[k] = rightArr[r];
                r++;
            }
            k++;
        }

        while (l < leftSize) {
            nums[k] = leftArr[l];
            l++;
            k++;
        }

        while (r < rightSize) {
            nums[k] = rightArr[r];
            r++;
            k++;
        }

        System.out.println("Sorted Array: " + printArr(nums));
    }

    public static String printArr(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int n: nums) {
            sb.append(n + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int[] nums = new int[]{64, 25, 12, 22, 11};
        obj.mergeSort(nums);
    }
}
