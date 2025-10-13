import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class RemovingStarsFromAString {
    /*
     * @param s: a string
     * @return: the string after removing stars
     * Algorithm: Stack (Deque)
     * Initialize an empty stack (which can be a list or array in most programming languages).
     * Iterate through the input string s character by character.
     * If the character is a star (*), check that the stack is not empty and pop the top character off the stack.
     * If the character is a non-star letter, push it onto the stack.
     * After the loop finishes, convert the list of characters in the stack into a single string.
     */
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if (c != '*') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();

//        for(Iterator<Character> it = stack.descendingIterator(); it.hasNext();) {
//            result.append(it.next());
//        }

        for(char c : stack) {
            result.append(c);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromAString solution = new RemovingStarsFromAString();
        String s = "leet**cod*e";
        System.out.println(solution.removeStars(s)); // Output: "lecoe"
    }
}
