import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PivotArrayRearrange {
    public static int[] pivotArray(int nums[], int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int num: nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        int index = 0;
        for(int num : less) {
            nums[index++] = num;
        }
        for(int num: equal) {
            nums[index++] = num;
        }
        for (int num: greater) {
            nums[index++] =  num;
        }
        return nums;
    }

    public static  void main(String args[]) {
        int nums1[] = {9, 12, 5, 10, 14, 3, 10};
        int pivot1 = 10;
        System.out.println(Arrays.toString(pivotArray(nums1, pivot1)));

        int nums2[] = {-3, 4, 3, 2};
        int pivot2 = 2;
        System.out.println(Arrays.toString(pivotArray(nums2, pivot2)));

    }
}
