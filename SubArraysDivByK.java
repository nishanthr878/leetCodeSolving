import java.util.HashMap;
import java.util.Map;

public class SubArraysDivByK {
    public int subArraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);
        int prefixsum = 0;
        int count = 0;

        for(int num : nums) {
            prefixsum += num;
            int mod = prefixsum % k;

            if(mod < 0) {
                mod += k;
            }

            if(remainderCount.containsKey(mod)) {
                count += remainderCount.get(mod);
            }

            remainderCount.put(mod, remainderCount.getOrDefault(mod, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraysDivByK solution = new SubArraysDivByK();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = solution.subArraysDivByK(nums, k);
        System.out.println("Number of subarrays divisible by " + k + ": " + result);
    }
}
