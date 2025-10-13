public class MincostclimbingStairs {
    /**
     * Calculates the minimum cost to reach the top of the floor.
     * @param cost The integer array where cost[i] is the cost of the i-th step.
     * @return The minimum total cost.
     */
    public int minCostClimbingStairs(int cost[]) {
        int n = cost.length;
        // Dynamic Programming: We can use the input array 'cost' itself
        // to store the minimum cost to reach and land on step 'i'.

        // Base Cases are implicitly handled by the loop starting at i=2,
        // as cost[0] and cost[1] are the initial minimum costs to land on those steps.

        // Iterate from the third step (index 2) up to the last step (index n-1)

        for(int i = 2; i < n; i++) {
            // Recurrence Relation:
            // The minimum cost to land on step i is the cost of step i
            // plus the minimum cost to land on the previous step (i-1) or
            // the step before that (i-2).
            cost[i] += Math.min(cost[i-1], cost[i -2]);
        }

        return Math.min(cost[n-1], cost[n-2]);
    }

    public static void main(String[] args) {
        MincostclimbingStairs solver = new MincostclimbingStairs();
        int[] cost = {10, 15, 20};
        System.out.println(solver.minCostClimbingStairs(cost)); // Output: 15
    }
}
