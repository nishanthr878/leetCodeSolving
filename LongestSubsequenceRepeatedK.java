import java.util.*;


public class LongestSubsequenceRepeatedK {
    public static  String  longestSubsequenceRepeatedK(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Filter chars that appear at least k times
        List<Character> candidates = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (freq.getOrDefault(ch, 0) >= k) {
                candidates.add(ch);
            }
        }

        String result = "";
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            for (char ch : candidates) {
                String next = curr + ch;

                // If next * k is a subsequence, and lex greater than result, update
                if (isKSubsequence(s, next, k)) {
                    if (next.length() > result.length() ||
                            (next.length() == result.length() && next.compareTo(result) > 0)) {
                        result = next;
                    }
                    // Only add to queue if length is less than 7
                    if (next.length() < 7) {
                        queue.offer(next);
                    }
                }
            }
        }

        return result;
    }
    private static boolean isKSubsequence(String s, String sub, int k) {
        int idx = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == sub.charAt(idx)) {
                idx++;
                if (idx == sub.length()) {
                    count++;
                    idx = 0;
                    if (count == k) return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        String s = "abcabcabc";
        int k = 2;
        System.out.println(longestSubsequenceRepeatedK(s, k)); // Output: "abc"

        s = "aaabbbccc";
        k = 3;
        System.out.println(longestSubsequenceRepeatedK(s, k)); // Output: "abc"

        s = "aabbcc";
        k = 2;
        System.out.println(longestSubsequenceRepeatedK(s, k)); // Output: "abc"
    }

}
