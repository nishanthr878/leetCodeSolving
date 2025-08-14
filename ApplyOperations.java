import java.util.Arrays;

public class ApplyOperations {
    public static int[] applyOperations(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n -1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int result[] = new int[n];
        int index = 0;

        for (int num: nums) {
            if(num != 0) {
                result[index++] = num;
            }
        }
        return result;

    }

    public static void main(String args[]) {
        int nums1[] = {1, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(applyOperations(nums1)));

        int nums2[] = {0, 1};
        System.out.println(Arrays.toString(applyOperations(nums2)));
    }
}
