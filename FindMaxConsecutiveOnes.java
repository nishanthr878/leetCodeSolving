public class FindMaxConsecutiveOnes {
    public int findMaxConsecutivesOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for(int num : nums) {
            if(num == 1) {
                currentCount++;
            }else {
                maxCount = Math.max(maxCount,currentCount);
                currentCount = 0;
            }
        }
        return Math.max(maxCount, currentCount);
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes solution = new FindMaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1,1};
        System.out.println(solution.findMaxConsecutivesOnes(nums)); // Output: 3
    }
}
