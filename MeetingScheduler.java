import java.security.cert.CertificateNotYetValidException;

public class MeetingScheduler {
    public static int maxFreeTime(int eventTime, int k, int startTime[], int endTime[]) {
        int count = startTime.length;
        int[] prefixSum = new int[count + 1];
        int maxFree = 0;

        for(int i = 0; i < count; i++) {
            prefixSum[i + 1] = prefixSum[i] + endTime[i] - startTime[i];
        }

        for (int i = k - 1; i < count; i++) {
            int occupied = prefixSum[i + 1] - prefixSum[i - k + 1];
            int windowEnd = (i == count - 1)? eventTime : startTime[i + 1];
            int windowStart = (i == k - 1) ? 0: endTime[i - k];
            int freetime = windowEnd - windowStart - occupied;
            maxFree = Math.max(maxFree, freetime);
        }
        return maxFree;
    }
    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5})); // ➤ 2
        System.out.println(maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10})); // ➤ 6
        System.out.println(maxFreeTime(5, 2, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})); // ➤ 0
    }
}
