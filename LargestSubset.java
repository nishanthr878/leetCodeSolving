import java.util.*;


public class LargestSubset {
    public static List<Integer> largestDivisibleSubset(int nums[]) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            if (isvalid(subset) && subset.size() > result.size()) {
                result = new ArrayList<>(subset);
            }
        }
        return result;
    }

    public static boolean isvalid(List<Integer> subset) {
        for(int i = 0; i < subset.size(); i++) {
            for(int j = i +1; j < subset.size(); j++) {
                int a = subset.get(i);
                int b = subset.get(j);

                if ( a % b != 0 && b % a != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int nums1[] = {1, 2, 3};
        int nums2[] = {1, 2, 3, 4};

        System.out.println("Example 1: " + largestDivisibleSubset(nums1));
        System.out.println("Example 2 " + largestDivisibleSubset(nums2));
    }
}
