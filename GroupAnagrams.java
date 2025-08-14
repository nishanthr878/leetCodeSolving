import java.util.*;

public class GroupAnagrams {
    /**
     * This method groups anagrams from the input array of strings.
     * @param strgs Array of strings to be grouped.
     * @return List of lists, where each inner list contains strings that are anagrams of each other.
     *
     * Algorithm:
     * 1. Create a map to hold sorted strings as keys and lists of anagrams as values.
     * 2. For each string in the input array:
     *   a. Convert the string to a character array.
     *   b. Sort the character array.
     *   c. Convert the sorted character array back to a string.
     *   d. Use this sorted string as a key in the map.
     *   e. Add the original string to the list corresponding to this key.
     *   f. Finally, return the values of the map as a list of lists.
     *
     */
    public static List<List<String>> groupAnagrams(String[] strgs){
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strgs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    /**
     * This method groups anagrams using a hash table based on character counts.
     * @param strs Array of strings to be grouped.
     * @return List of lists, where each inner list contains strings that are anagrams of each other.
     *
     * Algorithm:
     * 1. Create a map to hold character count arrays as keys and lists of anagrams as values.
     * 2. For each string in the input array:
     *   a. Create an integer array to count occurrences of each character (assuming lowercase letters).
     *   b. Convert the string into this character count array.
     *   c. Use the character count array as a key in the map.
     *   d. Add the original string to the list corresponding to this key.
     *   e. Finally, return the values of the map as a list of lists.
     */
    public static List<List<String>> groupAnagramsHashTable(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }


    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagramsHashTable(input);
        System.out.println(result);
    }
}
