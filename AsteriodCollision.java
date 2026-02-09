import java.util.ArrayDeque;
import java.util.Deque;

public class AsteriodCollision {
    /**
     * Abstrack thinking
     * we have
     * 1. A sequence
     * 2. Elements move either left(-) or right(+)
     * 3. A collision possible senairos
     *  - + + -> no collision
     *  - - - -> no collision
     *  - - + -> no collision
     *  - + - -> collision
     *
     *  System Thinking
     *  1. When asteriods collide with only the closest surviving asteriod oņ its left
     *  i.e Last in First out
     *
     *
     * @param asteriods
     * @return
     */
    public int[] asteroidCollision(int[] asteriods) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int a : asteriods) {
            boolean alive = true;

            if(a > 0) {
                stack.push(a);
            } else  {
                while(!stack.isEmpty() && stack.peek() > 0 && alive) {

                    int top = stack.peek();

                    if(top < - a) {
                        stack.pop();
                    } else if(top == -a) {
                        stack.pop();
                        alive = false;
                    } else {
                        alive = false;
                    }
                }
                if(alive) {
                    stack.push(a);
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        AsteriodCollision solution = new AsteriodCollision();
        int[] asteriods = {5, 10, -5};
        int[] result = solution.asteroidCollision(asteriods);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

}
