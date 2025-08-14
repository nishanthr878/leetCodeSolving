public class MaximumLength {
    /* * This method calculates the maximum length of a subsequence in an array
     * where the subsequence can be formed by alternating between even and odd numbers.
     *
     * @param nums The input array of integers.
     * @return The maximum length of the alternating subsequence.
     * * Time Complexity: O(n) - This is due to the single pass through the array.
     * * Space Complexity: O(1) - No additional space is used except for a few variables.
     *
     * Allgorithm:
     * 1. Initialize two counters: `count[0]` for even numbers and `count[1]` for odd numbers.
     * 2. Initialize two end counters: `end[0]` for the last even number and `end[1]` for the last odd number.
     * 3. Iterate through each number in the array:
     *   - Determine if the number is even or odd using `n % 2`.
     *  - Increment the corresponding count.
     *  - Update the end counter for the opposite parity to reflect the length of the subsequence.
     * 4. Return the maximum of the counts and end counters.
     *
     */
    public static int maximumLength(int nums[]) {
        int count[] = new int[2]; // count[0] = # of even numbers, count[1] = # of odd numbers
        // end[0] = length of longest subsequence ending in even number
        // end[1] = length of longest subsequence ending in odd number
        int end[] = new int[2];
        for(int n : nums) {
            int div = n % 2;
            count[div]++;  // count of evens or odds
            end[div] = end[1 - div] + 1; // alternate with previous parity
        }
        return Math.max(Math.max(count[0], count[1]), Math.max(end[0], end[1]));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Maximum Length: " + maximumLength(nums));
    }
}
