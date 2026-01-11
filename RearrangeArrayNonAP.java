import java.util.Arrays;

public class RearrangeArrayNonAP {
    public int[] rearangeArray(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] ans = new int[n];

        int left = 0, right = n - 1;
        int idx = 0;

        while (left <= right) {
            if(idx < n) {
                ans[idx++] = nums[left++];
            }
            if(idx < n) {
                ans[idx++] = nums[right--];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RearrangeArrayNonAP rearranger = new RearrangeArrayNonAP();
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = rearranger.rearangeArray(nums);
        System.out.println(Arrays.toString(result));
    }
}
