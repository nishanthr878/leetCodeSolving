import java.util.Arrays;

public class CandyDistribution {
    public static int candy(int ratings[]) {
        int n = ratings.length;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);

        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] > ratings[i -1] && candies[i] <= candies[i -1]) {
                    candies[i] = candies[i -1] + 1;
                    changed = true;
                }
                if (i < n -1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i+1]) {
                    candies[i] = candies[i+1] + 1;
                    changed = true;
                }
            }
        }
        int total = 0;
        for (int c: candies) {
            total += c;
        }
        return total;
    }

    public  static void main(String args[]) {
        int ratings1[] = {1, 0,2};
        int ratings2[] = {1, 2,2};

        System.out.println("minumum candies : "+ candy(ratings1));
        System.out.println(("minumum candies " + candy(ratings2)));
    }
}
