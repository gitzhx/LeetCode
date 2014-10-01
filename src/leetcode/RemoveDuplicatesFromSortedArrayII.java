package leetcode;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A)
	{
		int result = A.length;
		if(A.length <= 2)
			return result;
		for(int i = result - 1;i >= 2;i--)
		{
			if(A[i] == A[i - 1] && A[i] == A[i - 2])
			{
				for(int j = i + 1;j < result;j++)
				{
					A[j - 1] = A[j];
				}
				result--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] A = {1,1,1,2,2,3};
		int result = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(A);
		System.out.println("length :" + result);
		for(int i = 0;i < result;i++)
			System.out.println(A[i]);
		
	}

}
