import java.util.ArrayList;
import java.util.List;

public class AliceTyping2 {
    static final int MOD = 1_000_000_007;

    public static int countPossibleOrginalString(String word, int k) {
        int n = word.length();
        if (n == 0) {
            return 0;
        }
        List<Integer> groups = new ArrayList<>();
        int count = 1;

        // Step 1: Group consecutive characters
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count); // add last group

        // Step 2: DP
        int maxLength = n;
        long[] dp = new long[maxLength + 1];
        dp[0] = 1;

        for (int groupSize : groups) {
            long[] newDp = new long[maxLength + 1];
            long[] prefix = new long[maxLength + 2];
            for (int i = 0; i <= maxLength; i++) {
                prefix[i + 1] = (prefix[i] + dp[i]) % MOD;
            }

            for (int i = 0; i <= maxLength; i++) {
                int l = Math.max(0, i - groupSize);
                newDp[i] = (prefix[i] - prefix[l] + MOD) % MOD;
            }
            dp = newDp;
        }

        // Step 3: Count total strings with length >= k
        long result = 0;
        for (int i = k; i <= maxLength; i++) {
            result = (result + dp[i]) % MOD;
        }

        return (int) result;
    }

    public static void main(String args[]) {
        System.out.println(countPossibleOrginalString("aabccdd", 7));
        System.out.println(countPossibleOrginalString("aabbccdd", 8));
        System.out.println(countPossibleOrginalString("aaabbb", 3));
    }
}
