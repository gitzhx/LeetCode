package leetcode;


public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix)
	{
		if (matrix.length == 0)
			return 0;
		int maxAll = 0;
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] max = new int[row][];
		int[][] result = new int[row][];
		for(int i = 0;i < row;i++)
		{
			result[i] = new int[column];
			max[i] = new int[column];
		}
		for(int i = 0;i < column;i++)		//首先给第一行赋值，若为'1'，则赋值1,否则赋值0
		{
			if(matrix[0][i] == '0')
				result[0][i] = 0;
			else
				result[0][i] = 1;
		}
		for(int i = 1;i < row;i++)		//从第2行开始，动态规划方式赋值，result记录(i,j)处列最大长度
			for(int j = 0;j < column;j++)
			{
				if(matrix[i][j] == '1')
					result[i][j] = result[i-1][j] + 1;
				else
					result[i][j] = 0;
			}
//		for(int i = 0;i < row;i++)		//打印result矩阵
//		{
//			for(int j = 0;j < column;j++)
//			
//			{
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.printf("%n");
//		}
		for(int i = 0;i < row;i++)		//外围是二层循环，循环内求以每个(i,j)为右下角的最大矩形面积
			for(int j = 0;j < column;j++)
			{
				if(matrix[i][j] == '1')
				{
					max[i][j] = 0;
					for(int p = 1;p <= result[i][j];p ++)
					{
						int tmp = 0;
						int q = j;
						while(q >= 0 && result[i][q] >= p)
						{
							tmp += p;
							q--;
						}
						if(tmp > max[i][j])
							max[i][j] = tmp;
					}
					if(max[i][j] > maxAll)
						maxAll = max[i][j];
				}
			}
//		for(int i = 0;i < row;i++)		//打印max矩阵
//		{
//			for(int j = 0;j < column;j++)
//			
//			{
//				System.out.print(max[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return maxAll;
	}
}
