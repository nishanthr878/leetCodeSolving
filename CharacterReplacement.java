import java.util.HashMap;
import java.util.HashSet;

public class CharacterReplacement {
    public int characterReplacmentSlidingWindowOptimized(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0, maxF = 0;
        for(int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r),0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(r)));

            while((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }


    public int characterReplacmentSlidingWindow(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()) {
            charSet.add(c);
        }

        for(char c : charSet) {
            int count = 0, l = 0;
            for(int r = 0;  r < s.length(); r++) {
                if(s.charAt(r) == c) {
                    count++;
                }

                while((r - l + 1) - count > k) {
                    if(s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }


    public int characterReplacement(String s, int k) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxF = 0;
            for(int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxF = Math.max(maxF, count.get(s.charAt(j)));
                /**
                 * This part checks if the current substring (from index `i` to `j`)
                 * can be turned into a substring of repeating characters by replacing at most `k` characters.
                 * If so, it updates `res` with the maximum length found so far. Specifically:
                 * `(j - i + 1)` is the length of the current substring.
                 * - `maxF` is the count of the most frequent character in this substring.
                 * - `(j - i + 1) - maxF` is the number of characters that need to be replaced to make all characters the same.
                 * - If this number is less than or equal to `k`, the substring is valid, and `res` is updated if this substring is longer than previous ones.
                 */
                if((j - i + 1) - maxF <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CharacterReplacement cr = new CharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println(cr.characterReplacement(s, k)); // Output: 4
        System.out.println(cr.characterReplacmentSlidingWindow(s, k)); // Output: 4
        System.out.println(cr.characterReplacmentSlidingWindowOptimized(s, k)); // Output: 4
    }
}
