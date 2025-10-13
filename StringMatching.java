import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatching {
    /**
     * @param words an array of strings
     * @return a list of all strings in words that are substrings of another word in words
     * Algorithm:
     * Initialize a Set<String> called result.
     * Start the outer loop for i (for the potential substring)
     * Start the inner loop for j (for the potential parent string).
     * Inside the inner loop, check: if i != j
     * If they're different words, check the crucial condition: if words[j] contains words[i].
     * If the condition is true, add words[i] to the result Set
     * After the loops finish, convert the result Set back into a list/array for the final return.
     *
     */
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();

        for(int i = 0; i < words.length;i++) {
            for(int j = 0; j < words.length; j++) {
                if(i != j) {
                    if(words[j].contains(words[i])) {
                        result.add(words[i]);
                    }
                }
            }
        }
        return result.stream().toList();
    }

    public static void main(String[] args) {
        StringMatching sm = new StringMatching();
        String[] words = {"mass","as","hero","superhero"};
        System.out.println(sm.stringMatching(words)); // Output: ["as","hero"]
    }
}
