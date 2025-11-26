import java.util.ArrayList;
import java.util.List;

/**
 * Backtracking approach to generate all combinations of size k from a given array.
 * Time Complexity: O(n choose k) where n is the length of the array.
 * Space Complexity: O(k) for the recursion stack and current combination storage.
 */
public class CombinationGenerator {
    /** Generates all combinations of size k from the given array arr.
     * @param arr The input array from which combinations are to be generated.
     * @param k The size of each combination.
     */
    public static void generateCombinations(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        findCombinations(arr, k, 0, currentCombination, result);

        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    /** Helper method to find combinations using backtracking.
     * @param arr The input array.
     * @param k The size of each combination.
     * @param start The starting index for the current recursion.
     * @param currentCombination The current combination being built.
     * @param result The list to store all valid combinations.
     */
    private static void findCombinations(int[] arr, int k, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if(currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = start; i < arr.length; i++) {
            currentCombination.add(arr[i]);
            findCombinations(arr, k, i+1, currentCombination, result);
            currentCombination.remove(currentCombination.size() -1);
        }
    }

    /** Main method to test the combination generator.
     * @param args Command line arguments.
     */
    public static void main (String args[]) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;
        generateCombinations(arr, k);
    }
}
