package leetcode;
import java.lang.NullPointerException;

public class SingleNumber {
	public int singleNumber(int[] A)
	{
		if(A == null)
			throw new NullPointerException();
		int result = A[0];
		for(int i = 1;i < A.length;i++)
		{
			result ^= A[i];
		}
		return result;
	}
	public static void main(String[] args) {

	}

}
