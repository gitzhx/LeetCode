package leetcode;

public class UniqueBinarySearchTrees {
	/**
	 *就是求二叉树种树，公式是卡特兰数:C(2n,n)/(n+1)
	 *C(2n,n)直接计算容易超过4字节，可用动态规划求C(2n,n) -->运用帕斯卡公式拓展 k*C(n,k) = n*C(n-1,k-1)
	 */
	public int numTreesV1(int n)
	{
		if(n == 0 || n == 1)
			return 1;
		else
		{
			//TODO:大整数问题，帕斯卡拓展
			int[] A = new int[n + 1];
			A[0] = 1;					//下标i可理解为C(n+i,i)中的i，即A[0]表示C(n,0)
			for(int i = 1;i <= n;i++)
			{
				
				A[i] = A[i - 1] * (i + n) / i;
				//System.out.printf("A[%d] %d  A[%d] %d  i:%d n:%d%n",i-1,A[i-1],i,A[i],i,i+n);
				
			}
			return A[n] / (n + 1);
		}
	}
	/**
	 *动态规划：对于n有f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-1)*f(0)
	 */
	public int numTreesV2(int n)
	{
		int MAX = 10000;
		if(n ==0 || n == 1)
			return 1;
		else
		{
			int[] result = new int[MAX];
			result[0] = result[1] = 1;
tag:			for(int i = 2;i < MAX;i++)
			{
				for(int j = 0;j < i;j++)
				{
					result[i] += result[j] * result[i - 1 - j];
					//System.out.printf("%d %d %d %d %d%n",j,i-1-j,result[j],result[i-1-j],result[i]);
				}
				if(i == n)
					break tag;
			}
			return result[n];
		}
		
	}
}
