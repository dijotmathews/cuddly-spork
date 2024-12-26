public class MaxProfit2 {

    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int currentProfit = 0;

        int buyPrice = prices[0];

        for(int i=1; i < prices.length; i++) {
            if(buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                totalProfit += profit;
                currentProfit += profit;

                buyPrice = prices[i];
            } else {
                currentProfit = 0;
                buyPrice = prices[i];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args){
//        int[] prices ={1,2,3,4,5};
//        int[] prices ={7,6,4,3,1};
        int[] prices ={7,1,5,3,6,4};

        int profit = maxProfit(prices);

        System.out.println(profit);
    }
}
