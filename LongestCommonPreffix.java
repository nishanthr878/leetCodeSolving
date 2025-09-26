public class LongestCommonPreffix {
    /*
        *@param strs: String[]
        *@return: String
        * Handle Base Cases: If the list is empty, return "".
        * If it has one string, return that string.
        * Initialize: Set the first string, strs[0], as the initial longest_prefix.
        * Iterate: Loop through all the remaining strings in the array (starting from the second string, strs[1]).
        * Check & Shrink: Inside the loop, check if the current string starts with the longest_prefix.
        * If it doesn't, use a while loop to repeatedly remove the last character of longest_prefix until it does match the start of the current string,
        * or until the prefix becomes empty.
        * Return: After checking all strings, the final value of longest_prefix is the result.
     */
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        String longestPrefix = strs[0];

        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(longestPrefix) != 0) {
                longestPrefix = longestPrefix.substring(0, longestPrefix.length() -1);
                if(longestPrefix.isEmpty()){
                    return "";
                }
            }
        }
        return longestPrefix;
    }

    public static void main(String[] args) {
        LongestCommonPreffix solution = new LongestCommonPreffix();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs2)); // Output: ""

        String[] strs3 = {"interstellar", "internet", "internal", "interval"};
        System.out.println(solution.longestCommonPrefix(strs3)); // Output: "int"

        String[] strs4 = {"a"};
        System.out.println(solution.longestCommonPrefix(strs4)); // Output: "a"

        String[] strs5 = {};
        System.out.println(solution.longestCommonPrefix(strs5)); // Output: ""
    }
}
