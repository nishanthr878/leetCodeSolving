public class CustomSortSorting {
    /**
     * Custom Sort String
     * @param order
     * @param s
     * @return
     *
     * Algorithm:
     * 1. Create a count array of size 26 to store the frequency of each character in s.
     * 2. Iterate through the string s and populate the count array.
     * 3. Create a StringBuilder to build the result string.
     * 4. Iterate through each character in the order string:
     *    - For each character, append it to the StringBuilder as many times as it appears in s (using the count array).
     *    - Decrease the count in the count array accordingly.
     * 5. After processing all characters in order, append the remaining characters (those not in order) to the StringBuilder.
     * 6. Convert the StringBuilder to a string and return it.
     *
     * Time Complexity: O(n + m) where n is the length of s and m is the length of order.
     * Space Complexity: O(1) since the count array size is fixed (26 for lowercase letters).
     */
    public String cusotmSortString(String order, String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()) {
            while(count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }
        for(int i = 0; i < 26; i++) {
            while(count[i] > 0) {
                sb.append((char)(i + 'a'));
                count[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSortSorting css = new CustomSortSorting();
        String order = "cba";
        String s = "abcdabcd";
        System.out.println(css.cusotmSortString(order, s)); // Output: "ccbbdaad"
    }
}
