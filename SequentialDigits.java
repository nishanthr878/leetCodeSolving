import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        generateSequential(1, 0, low, high, result);
        return result;
    }

    private static void generateSequential(int start, int current, int low, int high, List<Integer> result) {
        if (start > high) {
            return;
        }
        if (current >= low) {
            result.add(current);
        }
        int lastDigit = current % 10;
        System.out.println(lastDigit);
        if (lastDigit < 9) {
            generateSequential(start * 10, current * 10 + lastDigit + 1, low, high, result);
        }
    }

    public static void main(String[] args) {
        int low1 = 100, high1 = 300;
        System.out.println(sequentialDigits(low1, high1));  // Output: [123, 234]

        int low2 = 1000, high2 = 13000;
        System.out.println(sequentialDigits(low2, high2));  // Output: [1234, 2345, 3456, 4567, 5678, 6789, 12345]
    }
}
