import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDup {
    public List<List<Integer>> subsetsWithDup(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * Backtracking helper method to generate subsets.
     * @param nums
     * @param start
     * @param current
     * @param result
     *
     * Backtracking visulization:
     * Start: []
     *
     * → add 1 → [1]
     *     → add 2 → [1,2]
     *         → add 2 → [1,2,2]
     *         → backtrack → [1,2]
     *     → backtrack → [1]
     * → backtrack → []
     *
     * → add 2 (first one) → [2]
     *     → add 2 (second one) → [2,2]
     * → backtrack → []
     */
    private void backtrack(
            int[] nums,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        System.out.println("Adding subset: " + current);
        result.add(new ArrayList<>(current));
        System.out.println("Current result: " + result + "\n");

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            System.out.println("→ Added " + nums[i] + ", current = " + current);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
            System.out.println("← Removed " + nums[i] + ", back to " + current + "with index " + ( current.size() -1)  +" and result will be" + result + "\n");
        }
    }


    public static void main (String args[]) {
        SubsetWithDup subsetWithDup = new SubsetWithDup();
        int nums[] = {1, 2, 2};
        List<List<Integer>> result = subsetWithDup.subsetsWithDup(nums);
        System.out.print(result);
    }
}
