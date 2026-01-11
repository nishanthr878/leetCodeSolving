public class AlternatingGroups2 {
    /**
     * Algorithm
     * 1. k tiles -> k - 1 comparisons
     * 2. Comparisons are between adjacent ot the first
     * 3. In a circle, the last tiles is adjacent ot the first
     * 4. we precompute those comparisons once in diff
     * 5. A group is valid IFF the next k - 1 values in diff are all 1
     *
     * Note: Modulo is only used to prevent index overflow, not to change logic
     * Note: to find the modulo if the first number(dividend) is smaller than the second number (divisor),
     *      we can simply return the dividend as the result.
     *
     * @param colors
     * @param k
     * @return
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;

        // Edge case: if k is 1, every tile is a valid group
        if (k == 1) {
            return n;
        }

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (colors[i] != colors[(i + 1) % n]) ? 1 : 0;
        }

        int windowSize = k - 1;
        int sum = 0;
        int count = 0;

        // Initial window
        for (int i = 0; i < windowSize; i++) {
            sum += diff[i];
        }
        if (sum == windowSize) count++;

        // Slide over circular array using modulo
        for (int start = 1; start < n; start++) {
            sum -= diff[start - 1];
            sum += diff[(start + windowSize - 1) % n];

            if (sum == windowSize) count++;
        }
        return count;

    }

    public static void main(String[] args) {
        AlternatingGroups2 solution = new AlternatingGroups2();
        int[] colors = {1, 0, 1, 0, 1};
        int k = 3;
        int result = solution.numberOfAlternatingGroups(colors, k);
        System.out.println("Number of alternating groups: " + result); // Output: 5
    }
}


