public class MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for(int j = i + 1; j < prices.length;j++) {
                int sell = prices[j];
                res = Math.max(res, sell - buy);
            }
        }
        return res;
    }

    public int maxProfitDP(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for(int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }

    public int maxProfitTwoPointers(int[] prices) {
        int l = 0;
        int r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }


    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        int prices[] = {7,1,5,3,6,4};
        System.out.println(mp.maxProfit(prices));
        System.out.println(mp.maxProfitTwoPointers(prices));
        System.out.println(mp.maxProfitDP(prices));
    }
}
