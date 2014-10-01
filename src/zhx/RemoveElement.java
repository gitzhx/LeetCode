package zhx;

public class RemoveElement {
	/**
	 *没有难度，从后向前找元素，找到则将其后面的元素向前移 
	 *移动是主要操作，分析移动次数：显然有elem都在数组前面移动次数最多，
	 *假设仅有A[1]==elem，移动次数为n-1;假设仅有A[1]==A[2]==elem,移动次数为(n-2)*2;以此类推...
	 *因此最坏情况是前n/2的元素是elem，此时移动次数为(n^2)/2
	 *即最坏时间复杂度O(n^2)
	 */
	public int removeElement(int[] A,int elem)
	{
		int length = A.length;
		for(int i = length - 1;i >= 0;i--)
		{
			if(A[i] == elem)
			{
				for(int j = i + 1;j < length;j++)
					A[j - 1] = A[j];
				length--;
			}
		}
		return length;
	}
	public static void main(String[] args) {
		int[] A = new int[]{1,1,1,1,1,2};
		int result = new RemoveElement().removeElement(A, 1);
		System.out.println("length :" + result);
		for(int i = 0;i < result;i++)
			System.out.println(A[i]);
	}

}
