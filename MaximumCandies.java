public class MaximumCandies {
    /**
     * Abstract Thinking
     * - The Problem:
     *  - Given resources that can be subdivided, find the maximum
     *    equal portion size we can distribute to k recipents
     * - To verify
     *   if we have can distribute the candies to n number of children?
     *   ex: each child gets 3 candies, can we distribute to 100 children?
     *      ``` If answer = 5 is possible
     *          Then answer = 4 is also possible ✓
     *          And answer = 3 is also possible ✓
     *          If answer = 6 is impossible
     *          Then answer = 7 is also impossible ✗
     *          And answer = 8 is also impossible ✗
     *      ```
     *
     * System Thinking:
     *  - Component 1: Search space design
     *      - if we have candies = [5,8,6]
     *      - What's the minimum candies per child?
     *      - what's the maximum candies per child?
     *  - Component 2: Validation Logic
     *    - Try this mental exercise: Given candies = [5, 8, 6] and k = 3, check if X=5 works:
     *    - From pile of 5: hom many children get 5 candies?
     *    - from pile of 8: how many children get 5 candies?
     *    - from pile of 6: how many children get 5 candies?
     *    - total children served
     *
     * @param candies
     * @param k
     * @return
     */
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;
        for(int candy : candies) {
            right = Math.max(right, candy);
        }

        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(canAllocate(candies, k, mid)) {
                result = mid; // save the last valid result
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private boolean canAllocate(int[] candies, long k, int target) {
        long totalChildrenServed = 0;
        for(int candy : candies) {
            totalChildrenServed += candy / target;
        }
        return totalChildrenServed >= k;
    }
}
