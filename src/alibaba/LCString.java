package alibaba;

public class LCString {
	public int lcstring(String text,String query)
	{
		if(text == null || query == null || text.length() == 0 || query.length() == 0)		//边界处理
			return 0;
		char[] textChars = text.toCharArray();
		char[] queryChars = query.toCharArray();
		int tLength = textChars.length;
		int qLength = queryChars.length;
		int[][] tmp = new int[tLength][];
		for(int i = 0;i < tLength;i++)
			tmp[i] = new int[qLength];
		for(int i = 0,j = 0;i < tLength;i++)		//初始化第一列
		{
			if(textChars[i] == queryChars[j])
				tmp[i][j] = 1;
			else
				tmp[i][j] = 0;
		}
		for(int j = 0,i = 0;j < qLength;j++)		//初始化第一行
		{
			if(textChars[i] == queryChars[j])
				tmp[i][j] = 1;
			else
				tmp[i][j] = 0;
		}
		for(int i = 1;i < tLength;i++)				//赋值数组
			for(int j = 1;j < qLength;j++)
			{
				if(textChars[i] == queryChars[j])
					tmp[i][j] = 1;
				else
					tmp[i][j] = 0;
			}
		int max = 0;
		int tmpMax = 0;
		for(int j = 0;j < qLength;j++)				//按列的对角线遍历
		{
			tmpMax = 0;
			for(int m = 0,n = j;m < tLength && n < qLength;m++,n++)
			{
				if(tmp[m][n] == 1)
					tmpMax += 1;
			}
			max = max > tmpMax ? max : tmpMax;
		}
		for(int i = 1;i < tLength;i++)				//按行的对角线遍历
		{
			tmpMax = 0;
			for(int m = i,n = 0;m < tLength && n < qLength;m++,n++)
			{
				if(tmp[m][n] == 1)
					tmpMax += 1;
			}
			max = max > tmpMax ? max : tmpMax;
		}
		return max;
	}
	public static void main(String[] args) {
		String text = "acbac";
		String query = "acaccbabb";
		int result = new LCString().lcstring(text, query);
		System.out.println(result);
	}

}
