public class ValidWord {
    public static boolean isValidWord(String word) {
        if(word.length() < 3) {
            return false;
        }
        String vowels = "aeiouAEIOU";
        boolean hasVowels = false;
        boolean hasCons = false;
        for(char c : word.toCharArray()) {
            if(!Character.isLetterOrDigit(c)) {
                return false;
            }
            if(Character.isLetter(c)) {
                if(vowels.indexOf(c) != -1) {
                    hasVowels = true;
                } else {
                    hasCons = true;
                }
            }
        }
        return hasVowels && hasCons;
    }

    public static void main(String[] args) {
        String word1 = "Hello123";
        String word2 = "Hi";
        String word3 = "A1b2C3";

        System.out.println(isValidWord(word1)); // Output: true
        System.out.println(isValidWord(word2)); // Output: false
        System.out.println(isValidWord(word3)); // Output: true
    }
}
