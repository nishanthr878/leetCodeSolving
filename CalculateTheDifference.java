public class CalculateTheDifference {
    public static int calculateDifference (int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for(int i = 1; i <= n; i++) {
            if(i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        return num1- num2;
    }
    public static void main(String args[]) {
        System.out.println(calculateDifference(10, 3));
        System.out.println(calculateDifference(5, 6));
        System.out.println(calculateDifference(5, 1));
    }
}
