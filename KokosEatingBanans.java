import java.util.Arrays;


public class KokosEatingBanans {
    /**
     * Abstract Thinking:
     * - What we have
     *  - An array of workloads
     *  - A rate `k`.
     *  - A function: How many hours does it take if rate = k?
     *  - we need the smallest k such taht hours <= h.
     *
     *  so
     *  - find the minimum `k` such that
     *  `toatlHours(k) <= h`
     *
     *  for one pile `p`, hours = ceil(p / k)
     *  in java
     *  hours = (p + k - 1) / k
     *
     * System Thinking
     * - totalHours(k) = sum of ceil(piles[i] / k)
     * - if k increases, totalHours(k) decreases.
     *
     * Defining search space:
     * - Lower bound of k
     * - low = 1 (minimum speed)
 * - Upper bound of k
     * - high = max(piles) (if k is greater than max(piles),
     *
     *
     * @param piles
     * @param h
     * @return
     */

    public int minEatingSpeedBinarySearch(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // find maximum pile
        for(int pile : piles) {
            high = Math.max(high, pile);
        }

        while(low < high) {
            int mid = low + (high - low) / 2;
            int totalHours = 0;

            for(int pile : piles) {
                totalHours += (pile + mid - 1) / mid; // ceil (pile / mid)
            }

            if(totalHours > h) {
                // too slow -> need bigger k
                low = mid + 1;
            } else {
                //works -> try smaller k
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        KokosEatingBanans keb = new KokosEatingBanans();
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(keb.minEatingSpeedBinarySearch(piles, h)); // Output: 4
    }
}
