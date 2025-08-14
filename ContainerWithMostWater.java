public class ContainerWithMostWater {
    public int maxAreaBruteForce(int[] heights){
        int res = 0;
        for(int i = 0; i < heights.length; i++) {
            for(int j = i + 1; j < heights.length; j++) {
                res = Math.max(res, Math.min(heights[i], heights[j]) * (j - i));
            }
        }
        return res;
    }

    public int maxAreaTwoPointers(int heights[]) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while( l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main (String args[]) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int heights[] = {1, 7, 2, 5, 5, 7, 3, 6};
        int maxArea = solution.maxAreaBruteForce(heights);
        System.out.println("Maximum area of water container: " + maxArea);
        maxArea = solution.maxAreaTwoPointers(heights);
        System.out.println("Maximum area of water container using two pointers: " + maxArea);
    }
}
