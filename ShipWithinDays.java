public class ShipWithinDays {
    /**
     * System Thinking Approach:
     * 1. The System: Ship + Conveyor Belt + time Constraints
     * 2. The Components:
     *   - Input array of package weights (ordered)
     *   - Constraint 1: must ship in order (can't rearrange)
     *   - Constraint 2:  Must finish within D days
     *   - Constraint 3: Ship has capacity limit
     * 3. The relationships:
     *  - Capacity affects how many packages fit per day, which affects total days needed.
     *
     * - Minimum capacity = max(weights)
     * - Maximum capacity = sum(weights)
     * so our search space is [max(weights), sum(weights)]
     *
     * Abstraction thinking:
     * We have to find a minimum threshold that satisfies a feasibility
     * check across ordered Chunks.
     */
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        for(int weight : weights) {
            left = Math.max(left,weight);
        }

        int right = 0;
        for(int weight : weights) {
            right += weight;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(canShipInDays(weights, mid, days)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canShipInDays(int[] weights, int capacity, int days) {
        int currentDays = 1;
        int totalWeight = 0;
        for(int weight : weights) {
            totalWeight = totalWeight + weight;
            if(totalWeight > capacity) {
                currentDays++;
                totalWeight = weight;
            }
        }
        return currentDays <= days;
    }

    public static void main(String[] args) {
        ShipWithinDays solution = new ShipWithinDays();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(solution.shipWithinDays(weights, days)); // Output: 15
    }
}
