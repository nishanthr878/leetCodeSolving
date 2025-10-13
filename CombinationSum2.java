import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum(int[] candiates, int target) {
        Arrays.sort(candiates);

        List<List<Integer>> results = new ArrayList<>();

        backtrack(candiates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(
            int[] candidates,
            int remainingTarget,
            int startIndex,
            List<Integer> currentCombination,
            List<List<Integer>> results
    ) {
        if(remainingTarget == 0) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {

            if(i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(candidates[i] > remainingTarget) {
                break;
            }

            currentCombination.add(candidates[i]);

            backtrack(
                    candidates,
                    remainingTarget - candidates[i],
                    i + 1,
                    currentCombination,
                    results
            );
            currentCombination.remove(currentCombination.size() -1);
        }
    }
}
