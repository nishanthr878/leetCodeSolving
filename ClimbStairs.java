public class ClimbStairs {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }

        int twoStepsBefore = 1;
        int oneStepBefore = 2;

        for(int i = 3; i <= n; i++) {
            int currentWays = oneStepBefore + twoStepsBefore;

            twoStepsBefore = oneStepBefore;
            oneStepBefore = currentWays;
        }
        return oneStepBefore;
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        int n = 5;
        int result = cs.climbStairs(n);
        System.out.println(result);
    }
}
