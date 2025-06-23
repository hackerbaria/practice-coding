package dsa.common;

public class SellStock {

    /**
     * This method calculates the maximum profit that can be achieved by buying and selling a stock once.
     * It uses a single pass algorithm to find the minimum price and calculate the maximum profit.
     *
     * @param prices an array of stock prices
     * @return the maximum profit
     */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 8, 4, 2, 9, 10};
        int maxProfit = maxProfit(prices);
        int maxProfitBruteForce = maxProfitWithBruteForce(prices);
        System.out.println("Maximum profit: " + maxProfit);
        System.out.println("Maximum profit using brute force: " + maxProfitBruteForce);

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            // Update minPrice if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit if we sell at the current price
            int profit = price - minPrice;
            // Update maxProfit if the current profit is higher
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static int maxProfitWithBruteForce(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
