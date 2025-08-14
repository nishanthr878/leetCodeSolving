import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KthSmallestProduct {
    public static void main(String[] args) {
        KthSmallestProduct ksp = new KthSmallestProduct();
        int[] nums1 = {2, 5};
        int[] nums2 = {3, 4};
        long k = 2;
        System.out.println(ksp.kthSmallestProduct(nums1, nums2, k)); // Output: 21
    }

    public long kthSmallestProduct(int nums1[], int nums2[], long k) {
        int n = nums1.length, m = nums2.length;
        long left = -10000000000L, right = 10000000000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = countLessEqual(nums1, nums2, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a >= 0) {
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long)a * nums2[mid] <= x) l = mid + 1;
                    else r = mid - 1;
                }
                count += l;
            } else {
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long)a * nums2[mid] <= x) r = mid - 1;
                    else l = mid + 1;
                }
                count += nums2.length - l;
            }
        }
        return count;
    }
}
