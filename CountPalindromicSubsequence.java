import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        Set<String> palindromes = new HashSet<>();

        for(char ch = 'a'; ch <=  'z'; ch++) {
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            if (first != -1 && last != -1 && first < last) {
                Set<Character> middle = new HashSet<>();
                for(int j = first+1; j < last; j++) {
                    middle.add(s.charAt(j));
                }
                for(char mid : middle) {
                    palindromes.add("" + ch + mid + ch);
                }
            }
        }
        return palindromes.size();
    }

    public static void main(String[] args) {
        CountPalindromicSubsequence cps = new CountPalindromicSubsequence();
        String s = "abca";
        System.out.println("Count of unique palindromic subsequences of length 3: " + cps.countPalindromicSubsequence(s));
    }
}
