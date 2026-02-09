import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    /**
     * - Constraints and invariants
     *
     * System thinking view
     * - pushed is "fixed order input". You do not get to rearrange it.
     * - popped is "demand sequence". it tells you what mush come out, in order.
     *
     *
     * Abstrack thinking
     * - Imagine this invariant:
     *  - At any moment, the next valut in popped must be either:
     *    1. "already be on top of the stack or
     *    2. "Still be waiting somwhere ahead in pushed"
     * - If it is neither, the sequence is invalid.
     *
     * Algorithm
     * 1. Create an empty stack
     * 2. set j = 0 (next required pop index).
     * 3. For each value x in pushed:
     *   a. Push x onto the stack.
     *   b. While the stack is not empty and the top of the stack equals popped[j]:
     *      i. Pop the stack.
     *      ii. Increment j by 1.
     * 4. After processing all pusheds:
     *  i. if j == popped.length, return true
     *  ii. else return false
     *
     *  Time complexity: O(n)
     *  Space complexity: O(n)
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int [] pushed, int [] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;

        for(int x : pushed) {
            stack.push(x);

            while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }

    public static void main(String[] args) {
        ValidateStackSequences validator = new ValidateStackSequences();

        int[] pushed1 = {1,2,3,4,5};
        int[] popped1 = {4,5,3,2,1};
        System.out.println(validator.validateStackSequences(pushed1, popped1)); // true

        int[] pushed2 = {1,2,3,4,5};
        int[] popped2 = {4,3,5,1,2};
        System.out.println(validator.validateStackSequences(pushed2, popped2)); // false
    }
}
