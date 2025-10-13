import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
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
            List<List<Integer>> results)
    {
        if(remainingTarget == 0) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        if(remainingTarget < 0) {
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];

            if(candidate > remainingTarget) {
                break;
            }

            currentCombination.add(candidate);
            backtrack(
                    candidates,
                    remainingTarget - candidate,
                    i,
                    currentCombination,
                    results
            );

            currentCombination.remove(currentCombination.size() -1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);
    }
}
