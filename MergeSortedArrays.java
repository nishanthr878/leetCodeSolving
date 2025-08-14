import java.awt.*;
import java.util.*;
import java.util.List;

public class MergeSortedArrays {
    public static List<List<Integer>> mregeArrays(int nums1[][], int nums2[][]) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num[] : nums1) {
            int id = num[0], val = num[1];
            map.put(id, map.getOrDefault(id, 0) + val);
        }

        for(int num[] :nums2) {
            int id = num[0], val = num[1];
            map.put(id, map.getOrDefault(id, 0) + val);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        result.sort(Comparator.comparing(a -> a.get(0)));
        return result;

    }

    public static void main(String args[]) {
        int nums1[][] = {{1, 2}, {2, 3}, {4, 5}};
        int nums2[][] = {{1, 4}, {3, 2}, {4, 1}};

        List<List<Integer>> mergedArray = mregeArrays(nums1, nums2);
        System.out.println(mergedArray);
    }

}
