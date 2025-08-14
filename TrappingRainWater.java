import java.util.Stack;

public class TrappingRainWater {
    public int trapBruteForce(int height[]){
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for(int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax)- height[i];
        }
        return res;
    }

    public int trapPrefixSuffixArrays(int height[]){
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n -1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.max(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public int trapStack(int height []) {
        if (height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int mid = height[stack.pop()];
                if(!stack.isEmpty()) {
                    int right = height[i];
                    int left = height[stack.peek()];
                    int h = Math.min(right, left) - mid;
                    int w = i - stack.peek() -1;
                    res += h * w;
                }
            }
            stack.push(i);
        }
        return res;
    }

    public int trapTwoPointers(int  height[]){
        if(height == null || height.length == 0) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r --;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    public static void main(String args[]){
        TrappingRainWater trw = new TrappingRainWater();
        int height[] = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        int result = trw.trapBruteForce(height);
        System.out.println("Trapped rainwater: " + result);
        result = trw.trapPrefixSuffixArrays(height);
        System.out.println("Trapped rainwater using prefix and suffix arrays: " + result);
        result = trw.trapStack(height);
        System.out.println("Trapped rainwater using stack: " + result);
        result = trw.trapTwoPointers(height);
        System.out.println("Trapped rainwater using two pointers: " + result);
    }
}
