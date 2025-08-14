import java.util.Arrays;

public class OptimisedApplyOperations {
    public static int [] applyOperations(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n-1; i++) {
            if(nums[i] == nums[i+1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int index = 0;
        for(int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return nums;
    }

    public static void main(String args[]) {
        int nums1[] = { 1, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(applyOperations(nums1)));
    }
}
