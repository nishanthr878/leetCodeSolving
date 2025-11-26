public class MinSwaps {
    public int minSwaps(String s) {
        int balance = 0;
        int minBalance = 0;
        int swap;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                balance++;
            } else {
                balance--;
            }
            minBalance = Math.min(minBalance, balance);
        }
        swap = ( - minBalance +1) / 2;
        return swap;
    }

    public static void main(String[] args) {
        MinSwaps ms = new MinSwaps();
        String s = "]]][[[";
        System.out.println("Minimum swaps needed: " + ms.minSwaps(s)); // Output: 2
    }
}
