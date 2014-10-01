package jzoffer;

public class MoreThanHalf {
	/**
	 *抵消策略,时间复杂度O(n),空间复杂度O(1) 
	 */
	public int moreThanHalf(int[] A)
	{
		if(A == null || A.length == 0)
			return 0;
		int result = A[0];
		int times = 1;
		for(int i = 1;i < A.length;i++)
		{
			if(times == 0)
				result = A[i];
			else if(result == A[i])
				times--;
			else
				times++;
		}
		times = 0;
		for(int i = 0;i < A.length;i++)
			if(result == A[i])
				times++;
		return times >= (A.length + 1) / 2 ? 0 : result;	//验证是否次数超过一半
	}
	public static void main(String[] args) {

	}

}
