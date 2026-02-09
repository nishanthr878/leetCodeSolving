public class SingleNonDuplicate {
    /**
     * Abstract thinking
     * Facts which we have from the problem:
     * - soreted array
     * - every number appears exactly twice.
     * - one lonely element appears once
     * - paris are adjacent
     * - O(log n)
     * so the system is a sequence of pairs until someting breaks.. then paris continue again.
     *
     * System thinking
     * - Before the single element: pairs start at even indices.
     * - After the single element: pairs start at odd indices.
     *
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            // forcing mid to be even
            if(mid % 2 == 1) {
                mid--;
            }

            if(nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main (String[] args) {
        SingleNonDuplicate s = new SingleNonDuplicate();
        int nums[] = {1,1,2,3,3,4,4,8,8};
        System.out.println(s.singleNonDuplicate(nums));
    }
}
