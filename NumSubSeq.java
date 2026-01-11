import java.util.Arrays;

public class NumSubSeq {
    public int numSubSeq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int mod = 1_000_000_007;
        int left = 0, right = n - 1;
        int[] pow2 = new int[n];
        pow2[0] = 1;

        for(int i = 1; i < n; i++) {
            pow2[i] = (pow2[i-1] * 2) % mod;
        }

        while(left <= right) {
            if(nums[left] + nums[right] <= target) {
                count = (count + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumSubSeq solution = new NumSubSeq();
        int[] nums = {3,5,6,7};
        int target = 9;
        int result = solution.numSubSeq(nums, target);
        System.out.println("Number of valid subsequences: " + result);
    }
}
