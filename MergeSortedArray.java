
public class MergeSortedArray {
    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     *
     * Algorithm:
     * 1. Initialize three pointers: p1 at the end of the initialized part of nums1, p2 at the end of nums2, and p at the end of nums1
     * 2. While p1 and p2 are both valid:
     *    - Compare nums1[p1] and nums2[p2]
     *    - Place the larger of the two at nums1[p] and move the corresponding pointer and p backwards
     * 3. If there are remaining elements in nums2, copy them to nums1
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m -1;
        int p2 = n -1;
        int p = m + n - 1;

        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        while(p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        return nums1;
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m =3, n = 3;
        int[] ans = solution.merge(nums1, m, nums2, n);
        for(int a : ans) {
            System.out.print(a);
        }

    }
}
