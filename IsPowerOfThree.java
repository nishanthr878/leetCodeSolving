public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if( n % 3 != 0) {
            return  false;
        }
        return isPowerOfThree(n /3);
    }

    public static void main(String[] args) {
        IsPowerOfThree solution = new IsPowerOfThree();
        System.out.println(solution.isPowerOfThree(27)); // true
        System.out.println(solution.isPowerOfThree(0));  // false
        System.out.println(solution.isPowerOfThree(9));  // true
        System.out.println(solution.isPowerOfThree(10)); // false
    }
}
