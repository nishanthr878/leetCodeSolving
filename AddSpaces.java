public class AddSpaces {
    /*
     * @param s: a string
     * @param spaces: an array of integers
     * @return: a string
     * Initialize a string builder (or a mutable string object) to hold the result.
     * Initialize an integer variable, say current_index, to 0.
     * Loop through every space index in the spaces array:
     *      Extract the substring from current_index up to (exclusive) the current space index.
     *      Append this substring to the result.
     *      Append a single space character (" ") to the result.
     *      Update current_index to the current space index (the start of the next word).
     *      After the loop finishes, extract the final substring from the last current_index to the end of the original string s and append it to the result.
     */
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int currentIndex = 0;
        for(int spaceIndex : spaces) {
            String word = s.substring(currentIndex, spaceIndex);
            result.append(word);
            result.append(" ");

            currentIndex = spaceIndex;
        }
        result.append(s.substring(currentIndex));

        return result.toString();
    }

    public static void main(String[] args) {
        AddSpaces solution = new AddSpaces();
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        String result = solution.addSpaces(s, spaces);
        System.out.println(result); // Output: "Leetcode Helps Me Learn"
    }
}
