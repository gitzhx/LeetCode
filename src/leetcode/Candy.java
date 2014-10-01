package leetcode;
import java.util.Arrays;

public class Candy {
	/**
	 *ratings值可相等!相邻两人若有相同的rating值，其所得糖果可任意
	 *顺序遍历ratings一遍，处理连续上升队列，再逆序遍历ratings处理连续下降队列(同时修正第一步的上升队列)
	 *时间复杂度O(n),空间复杂度O(n)
	 *运行时间424ms
	 */
	public int candyV1(int[] ratings)
	{
		if(ratings == null || ratings.length == 0)
			return 0;
		int[] value = new int[ratings.length];
		Arrays.fill(value,1);
		int total = 0;
		for(int i = 1;i < value.length;i++)
		{
			if(ratings[i] > ratings[i - 1] && value[i] <= value[i - 1])
				value[i] = value[i - 1] + 1;
		}
		for(int i = ratings.length - 2;i >= 0 ;i--)
		{
			if(ratings[i] > ratings[i + 1] && value[i] <= value[i + 1])
				value[i] = value[i + 1] + 1;
		}
		for(int i = 0;i < value.length;i++)
			total += value[i];
		return total;
	}
	
	/**
	 *改进了V1，不开辟数组，用变量记录当ratings[i] < ratings[i - 1]时所需要的修正值。
	 *时间复杂度O(n),空间复杂度O(1) 
	 *leetcode上运行为392ms
	 */
	public int candyV2(int[] ratings)
	{
		if(ratings == null || ratings.length == 0)
			return 0;
		else
		{
			int total = 0;
			int pre = 1;
			int length = 1;
			int mark = 0;
			boolean flag = false;
			total += pre;
			for(int i = 1;i < ratings.length;i++)
			{
				if(ratings[i] == ratings[i -1])
				{
					pre = 1;
					total += pre;
					length = 1;
					flag = false;
				}
				else if(ratings[i] > ratings[i - 1])
				{
					pre += 1;
					total += pre;
					length = 1; 
					flag = false;
				}
				else
				{
					length++;
					if(!flag)
					{
						mark = pre;
						flag = true;
					}
					if(pre != 1)
					{	
						pre = 1;
						total += pre;
					}
					else if(pre == 1 && mark < length)
					{
						mark++;
						pre = 1;
						total += length;
					}
					else if(pre == 1 && mark >= length)
					{
						pre = 1;
						total += length - 1;
					}
				}
			}
			return total;
		}
	}
	public static void main(String[] args) {
		int[] a = {1,2,1};
		System.out.println(new Candy().candyV2(a));
	}

}
