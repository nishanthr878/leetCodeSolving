import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int [] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        backtrack(nums, 0, currentSubset, result);
        return result;
    }
    private void backtrack(int[] nums, int start_index, List<Integer> currentSubset, List<List<Integer>> result) {
        // BASE CASE: If we have considered every element, we found a complete subset.
        if(start_index == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        // --- 1. THE EXCLUDE DECISION ---
        // We skip the current element and move to the next one.
        // The currentSubset remains unchanged.
        backtrack(nums, start_index+1, currentSubset, result);

        // --- 2. THE INCLUDE DECISION ---

        // Step A: ACTION (Choose)
        // Add the current number to the subset.
        currentSubset.add(nums[start_index]);

        // Step B: RECURSE (Explore)
        // Move to the next index to explore all subsets that include this number.
        backtrack(nums, start_index+1, currentSubset, result);

        // Step C: BACKTRACK (Un-Choose/Cleanup)
        // Remove the element we added to restore the list
        // to its state before this decision
        currentSubset.remove(currentSubset.size() -1);

    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }
}
