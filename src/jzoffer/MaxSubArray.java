package jzoffer;

public class MaxSubArray {
	public int maxSubArray(int[] A)
	{
		int max = Integer.MIN_VALUE;
		int tmp = 0;
		for(int i = 0;i < A.length;i++)
		{
			tmp += A[i];
			max = max > tmp ? max : tmp;
			tmp = tmp > 0 ? tmp : 0;
		}
		return max;
	}
	public static void main(String[] args) {
		int[] A = {1,-2,3,10,-4,7,2,-5};
		int result = new MaxSubArray().maxSubArray(A);
		System.out.println(result);
	}

}
