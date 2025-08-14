public class MaximumValueOrderedTriplet {
    public static long maxTripletValue(int nums[]) {
        int n = nums.length;
        long res = 0;
        for(int k = 2; k < n; k++) {
            int maxPrefix = nums[0];
            for(int j = 1; j < k; j++) {
                res = Math.max(res, (long) (maxPrefix - nums[j]) * nums[k]);
                maxPrefix = Math.max(maxPrefix, nums[j]);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int nums1[] = {12, 6, 1, 2, 7};
        System.out.println(maxTripletValue(nums1));

        int nums2[] = {1, 10, 3, 4, 19};
        System.out.println(maxTripletValue(nums2));

        int nums3[] = {1, 2, 3};
        System.out.println(maxTripletValue(nums3));
    }

}
