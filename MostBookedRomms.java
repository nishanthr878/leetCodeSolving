import java.util.Arrays;

public class MostBookedRomms {
    /**
     * Finds the index of the most booked room given meeting times and number of rooms.
     *
     * @param n        Number of rooms.
     * @param meetings Array of meetings, each with [start, end] time.
     * @return         Index of the most booked room.
     */
    public static int mostBooked(int n, int[][] meetings) {
        int count[] = new int [n];      // count[i]: number of times room i is booked
        long busy[] = new long[n];      // busy[i]: when room i will be free (end time of last meeting assigned)

        int res = 0;                    // Index of the most booked room
        int max = 0;                    // Maximum number of bookings for any room

        // Sort meetings by their start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Process each meeting
        for(int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            long earliest = Long.MAX_VALUE; // Earliest time any room will be free
            int roomIndex = -1;             // Index of the earliest available room
            boolean assigned = false;       // Whether the meeting has been assigned to a room

            // Try to assign the meeting to a room that is free at or before 'start'
            for (int j = 0; j < n; j++) {
                // Track the room that will be free the earliest (for fallback)
                if (busy[j] <= earliest) {
                    earliest = busy[j];
                    roomIndex = j;
                }
                // If room is free before meeting starts, assign it
                if (busy[j] <= start) {
                    busy[j] = end;      // Update room's next free time
                    count[j]++;         // Increment booking count
                    assigned = true;
                    break;
                }
            }
            // If no room is free, delay the meeting to the earliest available room
            if(!assigned) {
                busy[roomIndex] += (end - start); // Push meeting to when the room is free
                count[roomIndex]++;
            }
        }

        // Find the room with the maximum bookings
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        // Example usage
        int n = 2;
        int[][] meetings = {{0,10}, {1, 5}, {2, 7}, {3,4}};
        int result = mostBooked(n, meetings);
        System.out.println("Most booked room index: " + result);
    }
}
