package leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] A,int target)
	{
		if(A == null)
			return 0;
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		
		while(low <= high)
		{
			mid = (low + high) / 2;
			if(target == A[mid])
				return mid;
			else if(target < A[mid])
				high = mid - 1;
			else if(target > A[mid])
				low = mid + 1;
		}
		return low;
	}
	public static void main(String[] args) {
		int[] A = new int[]{1,3,5,6};
		int target = 7;
		int k = new SearchInsertPosition().searchInsert(A, target);
		System.out.println(k);
	}

}
