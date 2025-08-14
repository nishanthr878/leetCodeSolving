import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    private int nums1[];
    private int nums2[];
    private Map<Integer, Integer> frequencyMap;

    public FindSumPairs(int nums1[], int nums2[]) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.frequencyMap = new HashMap<>();

        for (int num: nums2) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Initialized with:");
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("freqMap = " + frequencyMap);
    }

    public void add(int index, int val) {
        int oldValue = nums2[index];
        int newValue = oldValue + val;

        nums2[index] = newValue;
        frequencyMap.put(oldValue, frequencyMap.get(oldValue) - 1);
        if (frequencyMap.get(oldValue) == 0) {
            frequencyMap.remove(oldValue);
        }
        frequencyMap.put(newValue, frequencyMap.getOrDefault(newValue, 0) + 1);

        System.out.println("After add(" + index + ", " + val + "):");
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("freqMap = " + frequencyMap);
    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int complement = tot - num;
            int freq = frequencyMap.getOrDefault(complement, 0);
            count += freq;
            if (freq > 0) {
                System.out.println("num1: " + num + ", looking for: " + complement + ", found: " + freq + " times");
            }
        }
        System.out.println("count(" + tot + ") = " + count);
        return count;
    }
}
