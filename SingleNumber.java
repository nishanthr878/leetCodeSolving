import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    /*
        [2, 5, 2, 4, 4]
        res = 0     → 0000
        res ^= 2    → 0000 ^ 0010 = 0010 (2)
        res ^= 5    → 0010 ^ 0101 = 0111 (7)
        res ^= 2    → 0111 ^ 0010 = 0101 (5)  ← the two 2’s cancel
        res ^= 4    → 0101 ^ 0100 = 0001 (1)
        res ^= 4    → 0001 ^ 0100 = 0101 (5)  ← the two 4’s cancel
     */

    public int singleNumberBitManipulation(int nums[]) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }


    public int singleNumberHashSet(int nums[]) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            if(seen.contains(num)) {
                seen.remove(num);
            } else {
                seen.add(num);
            }
        }
        return seen.iterator().next();
    }



    public int singleNumber(int nums[]) {
        for(int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for(int j = 0; j < nums.length; j++) {
                if(i != j && nums[i] == nums[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int nums[] = {4,1,2,1,2};
        System.out.println(sn.singleNumberBitManipulation(nums));
    }
}
