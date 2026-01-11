public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int baseSatisfied = 0;
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                baseSatisfied += customers[i];
            }
        }

        int windowSum = 0;
        for(int i = 0; i < minutes; i++) {
            if(grumpy[i] == 1) {
                windowSum += customers[i];
            }
        }

        int maxRecover = windowSum;

        for(int i = minutes; i < n; i++) {
            if(grumpy[i] == 1) {
                windowSum+= customers[i];
            }

            if(grumpy[i - minutes] == 1) {
                windowSum -= customers[i - minutes];
            }
            maxRecover = Math.max(maxRecover, windowSum);
        }
        return baseSatisfied + maxRecover;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner solution = new GrumpyBookstoreOwner();
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        int minutes = 3;
        int result = solution.maxSatisfied(customers, grumpy, minutes);
        System.out.println("Maximum satisfied customers: " + result); // Output: 16
    }
}
