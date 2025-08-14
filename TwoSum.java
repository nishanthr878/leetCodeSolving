import java.util.*;

public class TwoSum {
    /**
     * This method finds two indices in the array such that their corresponding values sum up to the target.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the two indices, or an empty array if no such indices exist.
     * * Time Complexity: O(n^2) - This is a brute force solution that checks every pair of indices.
     * * Space Complexity: O(1) - No additional space is used except for the result array.
     */
    public static int[] twoSum(int nums[], int target) {
        int result[] = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j=i+1; j< nums.length;j++){
                if(nums[i] + nums[j] == target){
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    /**
     * This method finds two indices in the array such that their corresponding values sum up to the target.
     * It uses sorting to reduce the time complexity.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the two indices, or an empty array if no such indices exist.
     * * Time Complexity: O(n log n) - This is due to the sorting step.
     * * * Space Complexity: O(n) - Additional space is used to store the sorted indices.
     */
    public static int[] twoSumSorting(int nums[], int target){
        int[][] A = new int[nums.length][2];
        for(int i =0; i < nums.length;i++){
            A[i][0] = nums[i];
            A[i][1] =i;
        }
        Arrays.sort(A, Comparator.comparingInt(a ->a[0]));
        int i = 0, j = nums.length -1;
        while (i < j) {
            int cur = A[i][0] + A[j][0];
            if(cur == target) {
                return new int[]{Math.min(A[i][1], A[j][1]), Math.max(A[i][1], A[j][1])};
            } else if (cur < target){
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int result[] = twoSumSorting(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    /**
     * This method finds two indices in the array such that their corresponding values sum up to the target.
     * It uses a HashMap to achieve O(n) time complexity.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the two indices, or an empty array if no such indices exist.
     * * Time Complexity: O(n) - This is due to the single pass through the array and the HashMap operations.
     * * Space Complexity: O(n) - Additional space is used for the HashMap.
     */
    public int[] twoSumHashMap(int [] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(indices.containsKey(diff) && indices.get(diff) != i) {
                return new int[]{i, indices.get(diff)};
            }
        }
        return new int[0];
    }

    /**
     * This method finds two indices in the array such that their corresponding values sum up to the target.
     * It uses a HashMap to achieve O(n) time complexity with an optimized approach.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the two indices, or an empty array if no such indices exist.
     * * Time Complexity: O(n) - This is due to the single pass through the array and the HashMap operations.
     * * Space Complexity: O(n) - Additional space is used for the HashMap.
     */
    public int[] twoSumHashMapOptimized(int nums[], int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)){
                return new int[]{prevMap.get(diff), i};
            }
            prevMap.put(num, i);
        }
        return new int[0];
    }
}
