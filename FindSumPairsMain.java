public class FindSumPairsMain {
    public static void main(String args[]) {
        FindSumPairs findSumPairs = new FindSumPairs(
                new int[]{1, 1, 2, 2, 2, 3},
                new int[]{1, 4, 5, 2, 4, 4}
                );

        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }
}
