import java.util.*;

public class FindTheDuplicateNumber {
    public int findDuplicateNumberFastAndSlow(int nums[]) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicateNumberHashSet(int nums[]) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            if(seen.contains(num)){
                return num;
            }
            seen.add(num);
        }
        return -1;
    }


    public int findDuplicateNumberSorting(int nums[]) {
      Arrays.sort(nums);
      for(int i = 0; i < nums.length; i++) {
          if(nums[i] == nums[i+1]) {
              return nums[i];
          }
      }
      return -1;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber finder = new FindTheDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = finder.findDuplicateNumberFastAndSlow(nums);
        System.out.println("The duplicate number is: " + duplicate);
    }
}
