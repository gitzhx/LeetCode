package zhx;
import java.lang.ArithmeticException;

public class DivideTwoIntegers {
	/**
	 *基本思想是做减法，不作处理在leetcode会超时
	 *考虑怎么减少做减法的次数：每次做减结束后，被减数加倍，商率加倍
	 *注意：这里全转化为long类型是为省去考虑tmp加倍时有可能发生的越界。 
	 */
	public int divide(int dividend,int divisor)
	{
		if(divisor == 0)
			throw new ArithmeticException();
		if(dividend == 0)
			return 0;
		long valueDividend = Math.abs((long)dividend);
		long valueDivisor = Math.abs((long)divisor);
		int flag;
		if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0)
			flag = 1;
		else
			flag = -1;
		long rate = 1l;
		long tmp = valueDivisor;
		long result = 0;
		while(valueDividend >= tmp)
		{
			result += rate;
			valueDividend -= tmp;
			rate += rate;
			tmp += tmp;
			if(tmp > valueDividend)
			{
				tmp = valueDivisor;
				rate = 1;
			}
		}
		return (int) (flag == 1 ? result : -result);
	}
	public static void main(String[] args) {
		int result = new DivideTwoIntegers().divide(Integer.MIN_VALUE, 1);
		System.out.println(result);
	}

}
