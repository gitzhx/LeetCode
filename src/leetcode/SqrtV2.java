package leetcode;



public class SqrtV2 {
	/**
	 * @author legend_zhx
	 * @param x为待球平方根整数
	 * @return x平方根的整数部分
	 */
	public double sqrt(int x)
	{
		double value = x;
		double low,high;
		double result;
		double tmp;
		if(value == 1)
			return 1;
		else if(value > 1)
		{
			low = 1;
			high = value;
		}
		else
		{
			low = value;
			high = 1;
		}
		result = (low + high) / 2;
		tmp = result * result;
		double last = result;
		while(tmp != value)
		{
			if(tmp > value)
			{
				high = result;
				result = (low + high) / 2;
			}
			else
			{
				low = result;
				result = (low + high) / 2;
			}
			tmp = result * result;
			if(result == last)
				break;
			else
			{
				last = result;
			}
		}
		return result;
		
	}
}
