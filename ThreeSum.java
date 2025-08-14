import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSumTwoPointers(int nums[]){
        Arrays.sort((nums));
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i +1, r= nums.length - 1;
            while ( l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if ( sum > 0) {
                    r--;
                } else  if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l -1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }


    public List<List<Integer>> threeSumHashMap(int nums[]){
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -(nums[i] + nums[j]);
                if (count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSumBruteForce(int nums[]){
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(tmp);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main (String args[]){
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ts.threeSumBruteForce(nums);
        System.out.println("Three Sum Brute Force Result: " + result);
        result = ts.threeSumHashMap(nums);
        System.out.println("Three Sum HashMap Result: " + result);
        result = ts.threeSumTwoPointers(nums);
        System.out.println("Three Sum Two Pointers Result: " + result);
    }
}
