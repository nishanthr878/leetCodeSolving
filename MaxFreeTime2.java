public class MaxFreeTime2 {
    /**
     * Calculates the maximum length of consecutive free time (zeros) in a timeline,
     * after moving at most one event (represented by '1') to a different free slot.
     *
     * @param eventTime  The total length of the timeline.
     * @param startTime  Array of start times for each event (sorted, non-overlapping).
     * @param endTime    Array of end times for each event (sorted, non-overlapping).
     * @return           The maximum consecutive free time achievable.
     */
    public static int fillTimeArray(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if (n == 0) return eventTime; // If no events, all time is free

        // 'gaps' array stores the lengths of free intervals between events.
        // gaps[0]: free time before the first event
        // gaps[i]: free time between end of event i-1 and start of event i
        // gaps[n]: free time after the last event
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0]; // Time before first event

        // Calculate free time between each pair of events
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1]; // Time between events
        }
        gaps[n] = eventTime - endTime[n - 1]; // Time after last event

        // 'largestRight[i]' stores the largest gap to the right of position i
        // This helps to quickly check if an event can be moved to a right-side gap
        int[] largestRight = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            largestRight[i] = Math.max(largestRight[i + 1], gaps[i + 1]);
        }

        int maxFree = 0, largestLeft = 0;
        // Try moving each event to a free gap to maximize consecutive free time
        for (int i = 1; i <= n; i++) {
            int duration = endTime[i - 1] - startTime[i - 1]; // Duration of current event
            boolean canFitLeft = largestLeft >= duration; // Can move event to the left gap
            boolean canFitRight = largestRight[i] >= duration; // Can move event to the right gap

            if (canFitLeft || canFitRight) {
                // If event can be moved, merge the two adjacent gaps and add the event's duration
                // This simulates removing the event from its current position and placing it in a free slot
                int merged = gaps[i - 1] + gaps[i] + duration;
                maxFree = Math.max(maxFree, merged);
            }

            // Update maxFree with the sum of two adjacent gaps (without moving any event)
            // This checks the best free interval if no event is moved
            maxFree = Math.max(maxFree, gaps[i - 1] + gaps[i]);
            // Update the largest gap seen so far on the left
            largestLeft = Math.max(largestLeft, gaps[i - 1]);
        }

        return maxFree;
    }

    public static void main(String[] args) {
        // Example usage
        int eventTime = 10;
        int[] startTime = {0, 3, 7, 9};
        int[] endTime = {1, 4, 8, 10};
        int maxConsecutiveZeros = fillTimeArray(eventTime, startTime, endTime);
        System.out.println("Maximum consecutive zeros after moving at most one '1': " + maxConsecutiveZeros);
    }
}
