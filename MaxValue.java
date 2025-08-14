import java.util.Arrays;

public class MaxValue {
    public static int maxValue(int events[][], int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] memo = new int[n][k + 1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, k, events, memo);
    }
    private static int findNextEvent(int[][] events, int index) {
        int low = index + 1, high = events.length - 1;
        int target = events[index][1];

        while (low <= high) {
            int mid = (low + high)/2;
            if (events[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private static int dfs(int i, int k, int[][] events, int[][] memo) {
        if (i >= events.length || k == 0) {
            return  0;
        }
        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int skip = dfs(i + 1, k, events, memo);

        int nextIndex = findNextEvent(events, i);
        int attend = events[i][2] + dfs(nextIndex, k - 1, events, memo);
        return memo[i][k] = Math.max(skip, attend);
    }

    public static void main(String[] args) {
        int[][] events = {
                {1, 2, 4},
                {3, 4, 3},
                {2, 3, 1}
        };
        int k = 2;
        int result = maxValue(events, k);
        System.out.println("Maximum value of non-overlapping events: " + result);
    }
}
