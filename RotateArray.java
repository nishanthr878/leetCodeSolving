public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k is greater than n

        reverse(nums, 0, n -1); // step 1: reverse the whole array
        reverse(nums, 0, k - 1); // step 2: reverse first k elements
        reverse(nums, k, n -1); // step 3: reverse the rest
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        ra.rotate(nums, k);
        // Output the rotated array
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
