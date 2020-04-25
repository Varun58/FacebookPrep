package problems;

public class BestTimeToBuyAndSellStockPart1_12 {

  public static void main(String[] args) {
    int[] stockPrices = {7, 1, 5, 3, 6, 4};
    System.out.println(new BestTimeToBuyAndSellStockPart1_12().maxProfit(stockPrices));
    System.out.println(new BestTimeToBuyAndSellStockPart1_12().maxProfitWithMultipleTxns(stockPrices));
  }

  // Single Txn
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      } else if (price - minPrice > maxProfit) {
        maxProfit = price - minPrice;
      }
    }

    return maxProfit;
  }

  public int maxProfitWithMultipleTxns(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }

  public int maxProfitWithMultipleTxnsApproach2(int[] prices) {
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }
}
