package leetcode;

public class BestTimeToBuyAndSellStock {
	/**
	 * 顺序遍历一遍,min记录到目前为止的最小值,每次遍历都算一遍若在这一天卖出能获得的最大收益,与历史收益比较，遍历完成时即找到最大收益。
	 * 实际是DP，核心是每一天之前的最低价格(1，前一天...最小价格2，当天价格。有关)
	 * 时间复杂度O(n)
	 */
	public int maxProfit(int[] prices)
	{
		if(prices.length <= 1)
			return 0;
		int min = Integer.MAX_VALUE;
		int profit = Integer.MIN_VALUE;
		int currentProfit = Integer.MIN_VALUE;
		for(int i = 0;i < prices.length;i++)
		{
			if(prices[i] < min)
				min = prices[i];
			currentProfit = prices[i] - min;
			if(currentProfit > profit)
				profit = currentProfit;
		}
		return profit;
	}
	public static void main(String[] args) {

	}

}
