public class SortColors {
    /**
     * Sorts the array containing only 0s, 1s, and 2s in-place using the Dutch National Flag algorithm.
     *
     * @param nums the array to sort; must contain only 0, 1, and 2
     *
     * Algorithm:
     * 1. Initialize three pointers: low = 0, mid = 0, high = nums.length - 1.
     * 2. While mid <= high:
     *    - if nums[mid] == 0: swap nums[low] and nums[mid]; low++; mid++;
     *    - if nums[mid] == 1: mid++;
     *    - if nums[mid] == 2: swap nums[mid] and nums[high]; high--;
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        sc.sortColors(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 0 0 1 1 2 2
    }
}
