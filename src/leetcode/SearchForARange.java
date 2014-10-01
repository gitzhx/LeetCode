package leetcode;

import java.lang.NullPointerException;
import java.util.Arrays;

public class SearchForARange {
	
	public int binarySearch(int[] A,int target)
	{
		if(A == null)
			throw new NullPointerException();
		else{
			
			int low = 0;
			int high = A.length - 1;
			int mid;
			while(low <= high)
			{
				mid = (low + high) /2;
				if(target == A[mid])
					return mid;
				else if(target < A[mid])
					high = mid - 1;
				else if(target > A[mid])
					low = mid + 1;
			}
			return -low-1;
		}
	}
	
	public int[] search(int[] A,int target)
	{
		int[] result = {-1,-1};
		int location = Arrays.binarySearch(A, target);
		int low = location,high = location;
		if(low < 0)
			return result;
		else
		{
				int i;
				for(i = 1;;)
				{
					if(i == 1 && low - i < 0 || i == 1 && A[low - i] != A[location])	//跳出条件：i==1且low-i(不存在)或(不等于所找值)
						break;
					else
					{
						if(low - i >= 0 && A[low - i] == A[location])					//注意上面的跳出条件，和这里的*2条件
							{low -= i;i *= 2;}
						else
							i = 1;
					}
				}
				for(i = 1;;)
				{
					if(i == 1 && high + i > A.length - 1 || i == 1 && A[high + 1] != A[location] )
						break;
					else
					{
						if(high + i <= A.length - 1 && A[high + i] == A[location])
							{high += i;i *= 2;}
						else
							i = 1;
					}
				}
				result[0] = low;
				result[1] = high;
				return result;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = new SearchForARange().search(A,11);
		System.out.println(B[0] + " " + B[1]);
	}

}
