public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        long chefAvailableTime = 0;
        int numCustomers = customers.length;

        for(int i = 0; i < numCustomers; i++) {
            int arriveTime = customers[i][0];
            int prepTime = customers[i][1];

            long actualStartTime = Math.max(arriveTime, chefAvailableTime);

            long orderFinshTime = actualStartTime + prepTime;

            chefAvailableTime = orderFinshTime;

            long waitingTime = orderFinshTime - arriveTime;

            totalWaitingTime += waitingTime;
        }

        double averageWaitingTime = (double) totalWaitingTime / numCustomers;

        return averageWaitingTime;
    }

    public static void main(String[] args) {
        AverageWaitingTime awt = new AverageWaitingTime();
        int[][] customers = {{1,2},{2,5},{4,3}};
        System.out.println(awt.averageWaitingTime(customers)); // Output: 5.00000
    }
}
