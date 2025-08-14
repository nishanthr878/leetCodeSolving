import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSubSequence {
    public static int[] maxSubSequence(int nums[], int k) {
        PriorityQueue<int []> minHeap = new PriorityQueue<>(
                (a, b) ->Integer.compare(a[0], b[0])
        );

        for(int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<int []> topKElements = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topKElements.add(minHeap.poll());
        }

        topKElements.sort((a, b) -> Integer.compare(a[1], b[1]));

        int result[] = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = topKElements.get(i)[0];
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = {2, 1, 3, 3};
        int k = 2;
        System.out.println(Arrays.toString(maxSubSequence(nums, k)));
    }
}
