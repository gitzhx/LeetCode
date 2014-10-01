package leetcode;

/**
 *想多了，回文数必须是正数 
 *主要思想：首先找出输入数的位数，然后依次取头取尾看是否相等
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x)
	{
		if(x < 0)
			return false;
		if(x > 0)
			x = -x;
		if(x > -10)
			return true;
		else
		{
			boolean result = true;
			int decimal = 10;
			while(x / decimal <= -10)		
			{
				decimal *= 10;
			}
			do{
				if(x / decimal != x % 10)
				{
					result = false;
				}
				x %= decimal;
				x = x / 10;
				decimal /= 100;
				if(x == 0)
					break;
			}
			while(decimal > 1);
			return result;
		
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		System.out.println(new PalindromeNumber().isPalindrome(x));
	}

}
