package leetcode;

public class SingleNumberII {
	/**
	 *同类题都可以这样做：有一个数出现1次，其他出现k(k>1)次
	 *两次时可以直接所有数异或即可
	 *思考：有两个数只出现一次，其他数出现两次怎么做？ 
	 */
	public int singleNumber(int[] A)
	{
		int tmp = 0;
		int result = 0;
		for(int pointer = 31;pointer >= 0 ;pointer--)
		{
			tmp = 0;
			for(int i = 0;i < A.length;i++)
			{
				tmp += A[i] >>> pointer & 1;
 			}
			tmp %= 3;
			result = result << 1;
			result = result ^ tmp;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] A = {0};
		System.out.println(new SingleNumberII().singleNumber(A));
	}

}
