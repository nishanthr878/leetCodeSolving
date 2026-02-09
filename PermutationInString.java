public class PermutationInString {
    /**
     * Main idea: Does s2 contain a substring whose character frequency vector equals that of s1?
     *
     * Abstract thinking
     * 1. Window size is fixed i.e s1
     * 2. Only two characters change per step
     * 3. A match happens only when counts align
     *
     * System thinking
     *  Inputs
     *      s1, s2
     *
     *  Internal memory
     *      26 counters
     *      current window position
     *  Transition rule
     *      Remove left char
     *      Add right char
     *
     *  Condition check
     *    Are all counters aligned with s1?
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        //Step1 : count frequency of s1
        for(int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
        }

        //Step2: sliding window over s2
        for(int i = 0; i < n; i++){
            window[s2.charAt(i) - 'a']++;
        }

        if(matches(need, window)) {
            return true;
        }

        for(int i = n; i < m; i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - n) - 'a']--;

            if(matches(need, window)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString pis = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = pis.checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
    }
}
