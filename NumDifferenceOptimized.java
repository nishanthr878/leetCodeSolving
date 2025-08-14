public class NumDifferenceOptimized {
    public static int calculateDiffernce(int n, int m) {
        int totalSum = n * (n+1)/2;
        int k = n/m;

        int divisibleSum = m * k * (k + 1) /2;

        return totalSum - 2 * divisibleSum;
    }
    public static void main(String args[]) {
        System.out.println(calculateDiffernce(10, 3));
        System.out.println(calculateDiffernce(5, 6));
        System.out.println(calculateDiffernce(5, 1));
    }
}
