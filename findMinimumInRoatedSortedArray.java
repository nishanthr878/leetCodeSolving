public class findMinimumInRoatedSortedArray {
    /*
    * Initialize: Set low to the first index and high to the last index.
    * Loop: Keep going as long as low is less than high.
    * Find Midpoint: Calculate mid = low + (high - low) / 2.
    * Compare and Adjust:
    * If nums[mid] > nums[high], the minimum is on the right. Set low = mid + 1.
    * If nums[mid] < nums[high], the minimum is mid or on the left. Set high = mid. 
    * Return: When the loop ends (low == high), the element at that index is the minimum.
     */
    public int findMin(int nums[]) {
      int n = nums.length;
      int low = 0, high = n - 1;
      while (low < high) {
          int mid = low + (high - low) / 2;
          if(nums[mid] > nums[high]) {
              low = mid + 1;
          }
          if (nums[mid] < nums[high]) {
              high = mid;
          }
      }
      return nums[low];
    }

    public static void main(String[] args) {
        findMinimumInRoatedSortedArray obj = new findMinimumInRoatedSortedArray();
        int nums[] = {3,4,5,1,2};
        System.out.println("The minimum element in the rotated sorted array is: " + obj.findMin(nums));
    }
}
