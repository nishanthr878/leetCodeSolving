import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute (int nums[]) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, results);
        return results;
    }

    private void backtrack(int[] nums, int startIndex, List<List<Integer>> list) {
        if(startIndex == nums.length) {
            list.add(
                    Arrays.stream(nums).boxed().collect(Collectors.toList())
            );
            return;
        }

        for(int i = startIndex; i < nums.length; i++) {
            // 1. Choose Action
            swap(nums, startIndex, i);

            // 2. Explore (Recursive call)
            backtrack(nums, startIndex+1, list);
            //3. un-choose action (backtrack)
            swap(nums, startIndex, i);
        }


    }

    private void swap(int[] nums, int i, int j) {
        int tempt = nums[i];
        nums[i] = nums[j];
        nums[j] = tempt;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1,2,3};
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }
}
