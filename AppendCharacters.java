public class AppendCharacters {
    /*
     * @param s: a string
     * @param t: a string
     * @return: return the minimum number of characters that need to be appended to the end
     * Calculating the Result
     * At the end of the loop, the value of j tells us:
     * Characters in t already covered by s = j.
     * The total number of characters in t is length(t).
     * Therefore, the remaining characters of t that must be appended to s are simply the ones we didn't cover:
     * Minimum Appends=length(t)−j
     * This final calculation gives us the minimum number of characters to append!
     * It's the length of the suffix of t that starts at index j.
     */
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();

        int i = 0, j = 0;
        while (i < n && j < m) {
            if(s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return m - j;
    }

    public static void main(String[] args) {
        AppendCharacters ac = new AppendCharacters();
        String s1 = "coaching";
        String t1 = "coding";
        System.out.println(ac.appendCharacters(s1, t1)); // Output: 3

        String s2 = "abcde";
        String t2 = "a";
        System.out.println(ac.appendCharacters(s2, t2)); // Output: 0

        String s3 = "z";
        String t3 = "abcde";
        System.out.println(ac.appendCharacters(s3, t3)); // Output: 5
    }
}
