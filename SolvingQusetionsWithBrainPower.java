public class SolvingQusetionsWithBrainPower {
    public static void main (String args[]) {
        SolvingQusetionsWithBrainPower sol = new  SolvingQusetionsWithBrainPower();

        int questions[][] = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(sol.maxPoinsts(questions));
    }

    public long maxPoinsts(int questions[][]) {
        return helper(questions, 0);
    }

    private long helper (int questions[][], int i) {
        if (i >= questions.length) {
            return 0;
        }

        int points = questions[i][0];
        int brainPower = questions[i][1];
        long solve = points + helper(questions, i + brainPower +1);

        long skip = helper(questions, i+ 1);

        return Math.max(solve, skip);
    }
}
