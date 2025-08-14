public class LongestSubsequence {
        public static int longestSubSequence(String s, int k) {
            int n = s.length();
            int zeros = 0, ones = 0;
            long values = 0, pow = 1;

            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
            }

            for (int i = n - 1; i >=0; i--) {
                if (s.charAt(i) == '1') {
                    if (values + pow  > k) {
                        continue;
                    }
                    values += pow;
                    ones++;
                }
                pow <<= 1;
                if (pow > k) {
                    break;
                }
            }
            return  zeros + ones;
        }

    public static void main(String[] args) {
        String s = "1100101";
        int k = 5;
        System.out.println(longestSubSequence(s, k)); // Output: 5
    }
}
