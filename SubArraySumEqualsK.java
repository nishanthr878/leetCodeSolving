import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subaraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int currentSum = 0, count = 0;

        for(int num : nums) {
            currentSum += num;
            if(prefixCount.containsKey(currentSum - k)) {
                count += prefixCount.get(currentSum - k);
            }
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK solution = new SubArraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = solution.subaraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result); // Output: 2
    }
}
