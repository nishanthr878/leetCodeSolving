import java.util.Arrays;

public class BinarySearch {
    public int builtIn(int nums[], int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index: -1;
    }

    public int iterativeBinarySearch(int nums[], int target) {
        int l = 0, r = nums.length -1;

        while(l <= r) {
            int m = l + ((r - l) / 2);
            if(nums[m] > target) {
                r = m -1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }



    public int recursiveBinarySearch(int l, int r, int nums[], int target) {
        if(l > r) {
            return -1;
        }
        int mid = l + (r - l)/2;

        if(nums[mid] == target) {
            return mid;
        }
        return (nums[mid] < target) ? recursiveBinarySearch(mid + 1, r, nums, target):
                recursiveBinarySearch(l, mid -1, nums, target);
    }

    public int search(int[] nums, int target) {
        return recursiveBinarySearch(0, nums.length -1, nums, target);
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(bs.search(nums, target));
        System.out.println(bs.iterativeBinarySearch(nums, target));
    }
}
