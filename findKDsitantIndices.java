import java.util.ArrayList;
import java.util.List;

public class findKDsitantIndices {
    public static List<Integer> findKdistantIndices(int nums[], int key, int k) {
        int n = nums.length;
        boolean[] isKDistinct = new boolean[n];

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
                for (int i = start; i <= end; i++) {
                    isKDistinct[i] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(isKDistinct[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int nums1[] = {3, 4, 9, 1, 3, 9, 5};
        int key1 = 9, k1 = 1;
        System.out.println(findKdistantIndices(nums1, key1, k1));

        int nums2[] = {2, 2, 2, 2, 2};
        int key2 = 2, k2 = 2;
        System.out.println(findKdistantIndices(nums2, key2, k2));
    }
}
