package zhx;
public class StringToInteger {
	/**
	 *思路整理：
	 *1，判断是否为空字符串
	 *2，trim之后看长度
	 *3，分离符号位和数字位
	 *4，开始做数字位转换（遇到非数字字符则停止转换）
	 */
	public int atoi(String str)
	{
		if(str == null)					//1,null串判断
			return 0;
		String tmp = str.trim();		//2,trim后的长度
		if(tmp.length() == 0)
			return 0;
		String value;
		int flag = 1;
		if(tmp.charAt(0) == '+')		//3,分离符号位和数字位
		{
			flag = 1;
			value = tmp.substring(1);
		}
		else if(tmp.charAt(0) == '-')
		{
			flag = -1;
			value = tmp.substring(1);
		}
		else
		{
			value = tmp.toString();
		}
		if(value.length() == 0)			//4,数字位解析
			return 0;
		else
		{
			long finalValue = 0L;
			for(int i = 0;i < value.length();i++)
			{
				if(Character.isDigit(value.charAt(i)))
				{
					finalValue *= 10;
					finalValue += value.charAt(i) - '0';
					if(finalValue * flag > Integer.MAX_VALUE)
						return Integer.MAX_VALUE;
					if(finalValue * flag < Integer.MIN_VALUE)
						return Integer.MIN_VALUE;
				}
				else
				{
					return (int)(finalValue * flag);
				}
			}
			return (int) (finalValue * flag);
		}
	}
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		int result = new StringToInteger().atoi("-214743 48");
		System.out.println(result);
	}

}
