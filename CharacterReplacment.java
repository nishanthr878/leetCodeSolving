public class CharacterReplacment {
    /**
     * math part of the problems is
     * (window length) - (count of most frequent character in window) <= k
     * why window lenght - maxFreq actually means
     * The minumum number of chaarcters you mush change to mae the entire window consist of one single repeated character.
     * For example
     *  Window = "AABAB"
     *  length = 5
     *  freq(A) = 3, freq(B) = 2 -> maxFreq = 3
     *  changes needed = length - maxFreq = 5 - 3 = 2
     *
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for(int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            while((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CharacterReplacment cr = new CharacterReplacment();
        String s = "AABABBA";
        int k = 1;
        int result = cr.characterReplacement(s, k);
        System.out.println("The length of the longest substring after replacement is: " + result);
    }
}
