import java.util.HashSet;
import java.util.Set;

public class AliceTyping {
    public static int countOrginalStrings(String word) {
        Set<String> result = new HashSet<>();
        result.add(word);

        for(int i = 1; i < word.length(); i++) {
            if(word.charAt(i) == word.charAt(i -1)) {
                int start = i -1;
                while (i < word.length() && word.charAt(i) == word.charAt(start)) {
                    i++;
                }
                int end = i;

                String group = word.substring(start, end);
                for (int j = 0 ; j < group.length(); j++) {
                    String newWord = word.substring(0, start + j) + word.substring(start + j + 1);
                    result.add(newWord);
                }
                i = end - 1;
            }
        }
        return result.size();
    }
    public static void main(String[] args) {
        System.out.println(countOrginalStrings("abbcccc"));
    }
}
