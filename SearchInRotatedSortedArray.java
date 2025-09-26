public class SearchInRotatedSortedArray {
    /*
    * We'll start with our usual binary search pointers, left at the beginning of the array and right at the end.
    * We'll keep going as long as left is less than or equal to right.
    * Inside the loop, we calculate the mid-index.
    * The very first thing we should check is if nums[mid] is our target.
    * If it is, we've found our answer, and we can stop.
    * If nums[mid] is not the target, we need to figure out which half to search.
    * If the left half is sorted (nums[left] <= nums[mid]):
    * If the target is in this sorted half (nums[left] <= target < nums[mid]),
    * we know we should search there. How do we update our pointers?
    * left = left
    * right = mid -1
    * if the target is not in this sorted half, we search the other half:
    * left = mid + 1
    * right = right
    * If the right half is sorted (nums[mid] < nums[right]):
    * If the target is in this sorted half (nums[mid] < target <= nums[right]),
    * we search there:
    * left = mid + 1
    * right = right
    * If the target is not in this sorted half, we search the other half:
    * left = left
    * right = mid - 1
    * If we exit the loop, it means the target is not in the array, and we return -1.
    * This approach ensures we always discard half of the array in each step
     */
    public int search(int nums[], int target){
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }
                if(nums[left] > target || target >= nums[mid]){
                    left = mid + 1;
                }
            }
            if(nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                if (nums[mid] >= target || target > nums[right]) {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(s.search(nums, target)); // Output: 4
    }
}
