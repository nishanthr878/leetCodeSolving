public class ConcatenationOfArray {
    public int[] getConcatenation(int nums[]) {
        int ans[] = new int[2 * nums.length];
        int idx = 0;
        for(int i = 0; i < 2; i++) {
            for(int num : nums) {
                ans[idx++] = num;
            }
        }
        return ans;
    }


    public int[] getConcatenationOnePass(int nums[]) {
        int n = nums.length;
        int ans[] = new int[2 * n];
        for(int i = 0; i < n; i++) {
            ans[i] = ans[i+n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ConcatenationOfArray obj = new ConcatenationOfArray();
        int nums[] = {1, 2, 3};
        int result[] = obj.getConcatenationOnePass(nums);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
