public class BestTimeToBuyAndSellStock {
    public int maxProfit(int prices[]) {
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for(int j = i+ 1; j < prices.length; j++) {
                int sell = prices[j];
                res = Math.max(res, sell - buy);
            }
        }
        return res;
    }

    public int maxProfitTwoPointer(int prices[]) {
        int l = 0, r = 1;
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
        BestTimeToBuyAndSellStock bf = new BestTimeToBuyAndSellStock();
        int prices[] = {10, 1, 5, 6, 7, 1};
        System.out.println(bf.maxProfit(prices));
        System.out.println(bf.maxProfitTwoPointer(prices));
    }

}
