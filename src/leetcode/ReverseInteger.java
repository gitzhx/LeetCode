package leetcode;

public class ReverseInteger {
	/**
	 *返回类型是int，需考虑末尾有0的情况、翻转后越界的情况 
	 *借助Long类型的int intValue()方法
	 */
	public long reverse(int x)
	{
		Long result = 0L;
		int tmp = 1;
		if(x < 0)
			tmp = -1;
		while(x != 0)
		{
			result *= 10;
			result += Math.abs(x % 10);
			x /= 10;
		}
		result *= tmp;
		if(result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		else
			return result.intValue();
	}
	public static void main(String[] args) {
		int x = 1002;
		long result = new ReverseInteger().reverse(x);
		System.out.println(result);
	}

}
