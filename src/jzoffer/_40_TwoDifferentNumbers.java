package jzoffer;

public class _40_TwoDifferentNumbers {
	public void twoDifferentNumbers(int[] A)
	{
		if(A == null || A.length < 2)
			return;
		int tmp = 0;
		int flag = 1;
		for(int i = 0;i < A.length;i++)
			tmp ^= A[i];
		while((flag & tmp) == 0)
			flag <<= 1;
		int tmp1 = 0,tmp2 = 0;
		for(int i = 0;i < A.length;i++)
		{
			if((A[i] & flag) > 0)
			{
				tmp1 ^= A[i];
			}
			else
				tmp2 ^= A[i];
		}
		System.out.println(tmp1);
		System.out.println(tmp2);
	}
	public static void main(String[] args) {
		new _40_TwoDifferentNumbers().twoDifferentNumbers(new int[]{7,9});
	}

}
