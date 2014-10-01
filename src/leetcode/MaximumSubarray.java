package leetcode;

public class MaximumSubarray {
	/**
	 *该方法属于动态规划，时间复杂度为O(n) 
	 */
	public int maxSubArray(int[] A)
	{
		int max = Integer.MIN_VALUE;
		int total = 0;
		for(int i = 0;i < A.length;i++)
		{
			if(total <= 0)
				total = A[i];
			else{
				total += A[i];
			}
			if(total > max)
				max = total;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int result = new MaximumSubarray().maxSubArray(A);
		System.out.println(result);
	}

}
