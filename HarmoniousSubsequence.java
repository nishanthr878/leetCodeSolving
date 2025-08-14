import java.util.HashMap;
import java.util.Map;

public class HarmoniousSubsequence {
    public static int findLHS(int nums[]){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLenght = 0;

        for (int key: map.keySet()) {
            if (map.containsKey(key + 1)) {
                int lenght = map.get(key) + map.get(key + 1);
                maxLenght = Math.max(maxLenght, lenght);
            }
        }
        return maxLenght;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums1)); // Output: 5

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(findLHS(nums2)); // Output: 2

        int[] nums3 = {1, 1, 1, 1};
        System.out.println(findLHS(nums3)); // Output: 0
    }
}
