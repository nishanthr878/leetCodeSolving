import java.util.Arrays;

public class KokosEatingBanans {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1;
        while(true) {
            long totalTime = 0;
            for(int pile : piles) {
                totalTime += (int) Math.ceil((double) pile / speed);
            }
            if(totalTime <= h) {
                return speed;
            }
            speed++;
        }
    }

    public int minEatingSpeedBinarySearch(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int mid = l + (( r - l) / 2);

            long totalTime = 0;
            for(int pile : piles) {
                totalTime += Math.ceil((double) pile / mid);
            }
            if(totalTime <= h) {
                res = mid;
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KokosEatingBanans keb = new KokosEatingBanans();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(keb.minEatingSpeed(piles, h)); // Output: 4
        System.out.println(keb.minEatingSpeedBinarySearch(piles, h)); // Output: 4
    }
}
