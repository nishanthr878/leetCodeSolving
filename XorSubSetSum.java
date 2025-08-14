

public class XorSubSetSum {
    public static int subsetXorSum(int nums[]) {
        int n = nums.length;
        int total = 0;

        int totalSubsets = 1 << n;

        for (int mask = 0; mask < totalSubsets; mask++) {
            int xor = 0;
            for(int i = 0; i < n; i++) {
                if ((mask & (1 << i)) !=0) {
                    xor ^= nums[i];
                }
            }
            total += xor;
        }
        return total;
    }

    public static void main(String args[]) {
        int nums1[] = {1, 3};
        System.out.println("Output: " + subsetXorSum(nums1));

        int nums2[] = {5, 1, 6};
        System.out.println("output " + subsetXorSum(nums2));

        int nums3[] = {3, 4, 5, 6, 7, 8};
        System.out.println("Output " + subsetXorSum(nums3));
    }
}
