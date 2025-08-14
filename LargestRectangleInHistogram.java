import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int heights[]) {
        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            int right = i + 1;
            while(right < n && heights[right] >= heights[i]) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left - 1) * heights[i]);
        }
        return maxArea;
    }

    public int largestRectangleAreaStack(int heights[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < heights.length) {
            if(stack.isEmpty()|| heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int right = i -1;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int area = heights[top] * (right - left);
                maxArea = Math.max(maxArea, area);
            }
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            int area = heights[top] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(heights));// Output: 10
        System.out.println("Largest Rectangle Area using Stack: " + solution.largestRectangleAreaStack(heights)); // Output: 10
    }
}
