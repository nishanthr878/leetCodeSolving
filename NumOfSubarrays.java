public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int target = k * threshold;

        int windowSum = 0;
        int count = 0;

        for(int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        if(windowSum >= target) {
            count++;
        }

        for(int i = k; i < n; i++) {
            windowSum += arr[i]; //add new element
            windowSum -= arr[i - k]; //remove element going out of the window

            if(windowSum >= target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumOfSubarrays solution = new NumOfSubarrays();
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        int result = solution.numOfSubarrays(arr, k, threshold);
        System.out.println("Number of subarrays: " + result); // Output: 3
    }
}
