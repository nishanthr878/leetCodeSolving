import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        System.out.println("Longest Consecutive Sequence Length: " + lcs.longestConsecutive(nums));
        System.out.println("Longest Consecutive Sequence Length (Sorting): " + lcs.longestConsecutiveSorting(nums));
        System.out.println("Longest Consecutive Sequence Length (HashSet): " + lcs.longestConsecutiveHashSet(nums));
        System.out.println("Longest Consecutive Sequence Length (HashMap): " + lcs.longestConsecutiveHashMap(nums));
    }

    public int longestConsecutiveHashMap(int nums[]){
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        for(int num:nums){
            if(!mp.containsKey(num)){
                mp.put(num, mp.getOrDefault(num -1, 0) + mp.getOrDefault(num + 1, 0)+1);
                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
                res = Math.max(res, mp.get(num));
            }
        }
        return res;
    }

    public int longestConsecutiveHashSet(int nums[]){
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int longest = 0;
        for(int num: numSet){
            if(!numSet.contains(num-1)){
                int length = 1;
                while(numSet.contains(num + length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public int longestConsecutiveSorting(int nums[]){
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while(i < nums.length){
            if(curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while(i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }

    public int longestConsecutive(int nums[]){
        int res = 0;
        Set<Integer> store = new HashSet<>();
        for(int num : nums){
            store.add(num);
        }

        for(int num : nums){
            int streak = 0, curr = num;
            while(store.contains(curr)){
                streak++;
                curr++;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}
