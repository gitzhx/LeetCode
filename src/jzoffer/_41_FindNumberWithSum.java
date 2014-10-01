package jzoffer;

class _41_Result{
	int left;
	int right;
	_41_Result(){}
	_41_Result(int left,int right){this.left = left;this.right = right;}
}
public class _41_FindNumberWithSum {
	public _41_Result findNumberWithSum(int[] A,int sum)
	{
		if(A == null || A.length <= 1)
			return null;
		int left = 0,right = A.length - 1;
		while(left < right)
		{
			int tmp = A[left] + A[right];
			if(tmp == sum)
				return new _41_Result(left,right);
			else if(tmp < sum)
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int[] A = new int[]{2, 7, 11, 15};
		_41_Result result = new _41_FindNumberWithSum().findNumberWithSum(A, 9);
		System.out.println(result.left + " " + A[result.left]);
		System.out.println(result.right + " " + A[result.right]);
	}

}
