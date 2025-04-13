package lc150;

public class MaxProfit {
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/4868897/most-optimized-kadane-s-algorithm-java-c-python-rust-javascript
    public static  int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];

        for(int i = 1; i  < prices.length; i++) {
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
            }  else if(prices[i] - buyPrice > maxProfit) {
                maxProfit = prices[i] - buyPrice;
            }
        }

        return maxProfit;
    }

//    public static int maxOf(int l, )
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};

        int profit = maxProfit(prices);

        System.out.println(profit);
    }
}
