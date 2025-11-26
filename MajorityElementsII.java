import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementsII {
    public List<Integer> majorityElement(int[] nums) {
        int numberOfTimes = nums.length /3;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int key : count.keySet()) {
            if(count.get(key) > numberOfTimes) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElementsII solution = new MajorityElementsII();
        int[] nums = {3,2,3};
        List<Integer> result = solution.majorityElement(nums);
        System.out.println(result); // Output: [3]
    }
}
