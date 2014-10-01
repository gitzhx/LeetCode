package leetcode;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A)
	{
		int length = 0;
		int i = 0;
		if(A.length <= 1)
			return A.length;
		else
		{
			i++;
			while(i < A.length)
			{
				if(A[length] != A[i])
				{
					A[++length] = A[i++];
					
				}
				else
				{
					i++;
				}
			}
		}
		return length+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,2};
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(A));
	}

}
