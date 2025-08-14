import java.util.ArrayList;
import java.util.List;

public class SumOfDistinctPowersOfThree {
    public static boolean checkPowerOfThree (int n) {
        List<Integer> powers = new ArrayList<>();
        int power = 1;
        while (power <= n) {
            powers.add(power);
            power*=3;
        }

        int subsetCount = (1 << powers.size());
        for(int i = 0; i < subsetCount; i++) {
            int sum = 0;
            for(int j = 0; j < powers.size(); j++) {
                if (( i & (1 << j)) != 0) {
                    sum += powers.get(j);
                }

            }
            if (sum == n) {
                return true;
            }
        }
        return false;
    }

    public static void main (String args[] ) {
        System.out.println(checkPowerOfThree(12));
        System.out.println(checkPowerOfThree(91));
        System.out.println(checkPowerOfThree(21));
    }
}
