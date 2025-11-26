import java.util.HashMap;

/**
 * Target interview question
 * Find the first non-repetative character in a string
 * Example:
 * Input: "aabbcde"
 * Output: "c"
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class NonRepatativeCharacter {
    public static void notReptativecharacter(String s) {
        HashMap<Character, Integer> characterString = new HashMap<>();
        for(char i : s.toCharArray()) {
            characterString.put(i, characterString.getOrDefault(i, 0) + 1);
        }
        for(char i: s.toCharArray()) {
            characterString.containsKey(i);
            if(characterString.get(i)  == 1) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabbcde";
        notReptativecharacter(s);
    }
}
