package leetcode;

public class MedianOfTwoSortedArrays {
	
	/**
	 * 经典！！！
	 *1，直接每次比较两个数组某数，然后删除排除部分，该解法边界循环部分处理完成之后不用O(n)的话比较麻烦。总时间复杂度大概可以接近O(log(min(m,n))),没处理好的话就只能O(max(m,n)) 
	 *2，因此采取另一种方法，每次减小查找范围，下次查找在新的范围内时间复杂度O(log(k))即O(log(m+n))
	 */
	public double findMedianSortedArrays(int A[],int B[])
	{
		if(A == null && B == null)
			throw new NullPointerException();
		else if(A == null && B.length % 2 != 0)
			return (double)B[B.length / 2];
		else if(A == null && B.length % 2 == 0)
			return ((double)B[B.length / 2] + (double)B[B.length / 2 - 1]) / 2;
		else if(B == null && A.length % 2 != 0)
			return (double)A[A.length / 2];
		else if(B == null && A.length % 2 == 0)
			return ((double)A[A.length / 2] + (double)A[A.length / 2 - 1]) / 2;
		else
		{
			int total = A.length + B.length;
			if(total % 2 != 0)
				return (double)this.findK(A,B,total / 2 + 1);
			else
				return ((double)this.findK(A, B, total / 2) + (double)this.findK(A, B, total / 2 + 1)) / 2;
		}
	}
	private int findK(int[] A,int[] B,int k)
	{
		if(k <= 0 || A.length + B.length < k)
			throw new NullPointerException();
		int lowA = 0,highA = A.length - 1,lengthA = A.length;
		int lowB = 0,highB = B.length - 1,lengthB = B.length;
		int locationA = 0;
		int locationB = 0;
		int distance = 0;
		while(lengthA > 0 && lengthB > 0 && k > 1)
		{
			distance = k / 2 - 1;
			int tmp = (lengthA < lengthB ? lengthA : lengthB) - 1;
			distance = distance < tmp ? distance : tmp;
			locationA = lowA + distance;
			locationB = lowB + distance;
			if(A[locationA] == B[locationB])
			{
				if(k % 2 == 0)
					return A[locationA];
				else
				{
					if(locationA == highA)
						return B[locationB + 1];
					else if(locationB == highB)
						return A[locationA + 1];
					else
						return A[locationA + 1] < B[locationB + 1] ? A[locationA + 1] : B[locationB + 1];
				}
			}
			else if(A[locationA] < B[locationB])
			{
				k -= (locationA - lowA + 1);
				lowA = locationA + 1;
				lengthA = highA - lowA + 1;
			}
			else
			{
				k -= (locationB - lowB + 1);
				lowB = locationB + 1;
				lengthB = highB - lowB + 1;
			}
		}
		if(lengthA <= 0)
			return B[lowB + k - 1];
		if(lengthB <= 0)
			return A[lowA + k - 1];
		return A[lowA] < B[lowB] ? A[lowA] : B[lowB];
	}
	
	
	
	
	public static void main(String[] args) {
		int[] A = new int[]{1,2,3,4,5};
		int[] B = new int[]{2,3,4,5,6};
//		int k = 1;
//		int tmp = new MedianOfTwoSortedArrays().findK(A, B,k);
		double mid = new MedianOfTwoSortedArrays().findMedianSortedArrays(A, B);
		System.out.println(mid);
	
	}

}
