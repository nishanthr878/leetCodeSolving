import java.util.Arrays;

public class SuccessfulPairs {
    /**
     * System Thinking
     * - a fixed spell s
     * - a set of potions
     * - a success threshold
     * - for given spell s,
     *   - `s * potion >= success`
     * - rearrange it
     *   - potion > = ceil(success / s)
     * so for every spell, count elements in another array that are >= a computed threshold.
     *
     * Abstract Thinking
     * - Order doesn't matter for potions => sort them
     * - once potions are sorted:
     *   - if a potion at index i works
     *   - every potion to the right also works
     * - binary search bouandyr
     * - we have to just count the a suffix that's it
     *
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulParis(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // system setup: enforce montonicity

        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            long spell = spells[i];

            long minPotion = (success + spell - 1) / spell;

            int idx = lowerBound(potions, minPotion);
            result[i] = m - idx;
        }
        return result;
    }

    private int lowerBound(int[] potions, long target) {
        int left = 0, right = potions.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main (String[] args) {
        SuccessfulPairs s = new SuccessfulPairs();
        int spells[] = {5, 1, 3};
        int potions[] = {1, 2, 3, 4, 5};
        long success = 7;
        int result[] = s.successfulParis(spells, potions, success);
        for(int r : result) {
            System.out.print(r + " ");
        }
    }

}
