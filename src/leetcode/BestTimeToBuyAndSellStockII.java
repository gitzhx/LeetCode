package leetcode;

public class BestTimeToBuyAndSellStockII {
	/**
	 *从效果上来看，获得最大收益即是：卖出比买入都盈利，且在这一系列价格变动中，总盈利达到最大(实际购买操作并不一定是这样)。
	 *贪心(有利必图)
	 *时间复杂度O(n) 
	 */
	public int maxProfit(int[] prices)
	{
		if(prices.length <= 1)
			return 0;
		int min = Integer.MAX_VALUE;
		int profit = 0;
		int tmpProfit = 0;
		for(int i = 0;i < prices.length;i++)
		{
			if(prices[i] < min)
				min = prices[i];
			tmpProfit = prices[i] - min;
			if(tmpProfit > 0)
			{
				profit += tmpProfit;
				min = prices[i];
			}
		}
		return profit;
	}
	public static void main(String[] args) {

	}

}
