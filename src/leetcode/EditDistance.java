package leetcode;

public class EditDistance {
	/**
	 *DP，与LCS有点类似，求dis(A[1:i],B[1:j])与dis(A[1:i-1],B[1:j])、dis(A[1:i],B[1:j-1])、dis(A[1:i-1],B[1:j-1])
	 *三个分别对应三种可执行的操作,时间复杂度为O(n^2) 
	 */
	public int minDistance(String word1,String word2)
	{
		if(word1 == null || word2 == null)	//边界情况处理，word1、word2存在空串时					
		{	int tmp1 = 0;
			int tmp2 = 0;
			if(word1 != null)
				tmp1 = word1.length();
			if(word2 != null)
				tmp2 = word2.length();
			return Math.max(tmp1, tmp2);
		}
		if(word1.length() == 0 || word2.length() == 0)
			return Math.max(word1.length(), word2.length());
		
		int length1 = word1.length();
		int length2 = word2.length();
		char[] chars1 = new char[length1 + 1];
		char[] chars2 = new char[length2 + 1];
		System.arraycopy(word1.toCharArray(), 0, chars1, 1, length1);
		System.arraycopy(word2.toCharArray(), 0, chars2, 1, length2);
//		for(char c:chars1)
//			System.out.println(c);
//		System.out.println(length1);
//		for(char c:chars2)
//			System.out.println(c);
//		System.out.println(length2);
		
		int[][] record = new int[length1 + 1][length2 + 1];		//定义DP使用到的二维数组
		for(int i = 0;i <= length1;i++)
			record[i][0] = i;
		for(int j = 0;j <= length2;j++)
			record[0][j] = j;
		int up = 0;
		int left = 0;
		int upleft = 0;
		for(int i = 1;i <= length1;i++)
			for(int j = 1;j <= length2;j++)
			{
				up = record[i - 1][j] + 1;
				left = record[i][j - 1] + 1;
				if(chars1[i] == chars2[j])
					upleft = record[i - 1][j - 1];
				else
					upleft = record[i - 1][j - 1] + 1;
				record[i][j] = Math.min(Math.min(up, left), upleft);
			}
//		for(int i = 0;i <= length1;i++)
//		{
//			for(int j = 0;j <= length2;j++)
//			{
//				System.out.print (record[i][j] + "  ");
//			}
//			System.out.println();
//		}		
		return record[length1][length2];
	}
	public static void main(String[] args) {
		String word1 = "eeba";
		String word2 = "abca";
		int result = new EditDistance().minDistance(word1, word2);
		System.out.println(result);
	}

}
