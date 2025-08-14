import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequentHeap(int nums[], int k){
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int []> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(heap.size() > k) {
                heap.poll();
            }
        }
        System.out.println("heap ");
        for(int[] arr : heap) {
            System.out.println(arr[0] + " " + arr[1]);
        }
        int res[] = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        int[] result = solution.topKFrequentElements(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }

        // Example usage of topKFrequentHeap
        int[] heapResult = topKFrequentHeap(nums, k);
        System.out.println("\nTop " + k + " frequent elements using heap:");
        for (int num : heapResult) {
            System.out.print(num + " ");
        }

        // Example usage of topKFrequentBuckenSort
        int[] bucketSortResult = solution.topKFrequentBuckenSort(nums, k);
        System.out.println("\nTop " + k + " frequent elements using bucket sort:");
        for (int num : bucketSortResult) {
            System.out.print(num + " ");
        }
    }

    public int[] topKFrequentBuckenSort(int nums[], int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];

        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        System.out.println("count " + count);
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        System.out.println("freq " + Arrays.toString(freq));
        int res[] = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i >= 0 && index < k; i--) {
            for(int n : freq[i]) {
                res[index++] = n;
                if(index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    public int[] topKFrequentElements(int[] nums, int k){
        if(nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 2) {
                System.out.println("Key with frequency 2: " + entry.getKey());
            }
        }
        List<Integer> keysWithFrquencyK = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry :frequencyMap.entrySet()){
            if(entry.getValue() >= k){
                keysWithFrquencyK.add(entry.getKey());
            }
        }
        int[] resultArray = keysWithFrquencyK.stream().mapToInt(Integer::intValue).toArray();
        return resultArray;
    }
}
