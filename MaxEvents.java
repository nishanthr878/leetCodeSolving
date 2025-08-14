import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {
    public static void main(String args[]) {
        MaxEvents sovler = new MaxEvents();
        int events[][] = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(sovler.maxEvents(events));

        int events2[][] = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        System.out.println(sovler.maxEvents(events2));
    }

    public int maxEvents(int events[][]) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, n = events.length, day = 0, res = 0;

        int lastDay = 0;
        for(int event[] : events) {
            lastDay = Math.max(lastDay, event[1]);
        }

        for (day = 1; day <= lastDay; day++) {
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }
        return res;
    }
}
