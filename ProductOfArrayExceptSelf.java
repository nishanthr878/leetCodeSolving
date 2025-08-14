public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelfPrefixAndSuffix(int nums[]){
        int n = nums.length;
        int res[] = new int[n];
        int pref[] = new int[n];
        int suff[] = new int[n];

        pref[0] = 1;
        suff[n -1] = 1;
        for(int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
            System.out.println("pref[i] = " + pref[i]);
        }

        for(int i = n - 2; i >= 0; i--) {

            suff[i] = nums[i + 1] * suff[i + 1];
            System.out.println("suff[i] = " + suff[i]);
        }

        for(int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
            System.out.println("res[i] = " + res[i]);
        }
        return res;
    }

    public static int[] productExceptSelfDivision(int nums[]){
        int prod = 1, zeroCount = 0;
        for(int num : nums){
            if(num != 0){
                prod *= num;
            } else {
                zeroCount++;
            }
        }

        // If there are more than one zero, the product of all elements except self will be zero
        if(zeroCount > 1) {
            return new int[nums.length];
        }

        int res[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;
                System.out.println("res[i] = " + res[i]);
            } else {
                res[i] = prod / nums[i];
            }
        }
        return res;
    }

    public static int[] productExceptSelfBruteForce(int nums[]){
        int n = nums.length;
        int res[] = new int [n];

        for(int i = 0; i < n; i++) {
            int prod = 1;
            for(int j = 0; j < n; j++) {
                if(i != j){
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int result[] = productExceptSelfPrefixAndSuffix(nums);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
