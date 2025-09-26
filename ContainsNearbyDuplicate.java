import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyDuplicate {
//
//    public boolean containsNearbyDuplicateHashSet(int nums[], int k) {
//        Set<Integer> window = new HashSet<>();
//        int L = 0;
//
//        for(int R = 0;)
//    }

    public boolean containsNarbyDuplicateHashMap(int nums[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        for(int L = 0; L < nums.length; L++) {
            for(int R = L+ 1; R < Math.min(nums.length, L + k + 1); R++) {
                if(nums[L] == nums[R]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsNearbyDuplicate obj = new ContainsNearbyDuplicate();
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(obj.containsNearbyDuplicateBruteForce(nums, k)); // true
    }
}
