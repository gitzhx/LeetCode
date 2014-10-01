package zhx;

public class MergeSortedArray {
	/**
	 *归并排序的merge阶段，要求将融合结果存在A中，
	 *一开始先将A中元素整体后移n个位置(从后向前遍历移动，不然有可能覆盖部分元素)，再做融合
	 *时间复杂度O(m+n)
	 */
	public void merge(int A[],int m,int B[],int n)
	{
		int startA = 0;
		int startB = 0;
		int endA = m;
		int endB = n;
		startA += n;
		endA += n;
		for(int i = endA - 1;i >= startA;i--)
		{
			A[i] = A[i - n];
		}
		int ia = startA,ib = startB,k = 0;
		while(ia < endA && ib < endB)
		{
			if(A[ia] <= B[ib])
				A[k++] = A[ia++];
			else
				A[k++] = B[ib++];
		}
		while(ia < endA)
		{
			A[k++] = A[ia++];
		}
		while(ib < endB)
		{
			A[k++] = B[ib++];
		}
	}
	public static void main(String[] args) {
		int[] A = new int[]{1};
		int[] B = new int[]{};
		new MergeSortedArray().merge(A, 1, B, 0);
		for(int i = 0;i < 1;i++)
			System.out.println(A[i]);
		
	}

}
