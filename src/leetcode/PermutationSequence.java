package leetcode;
import java.util.ArrayList;

public class PermutationSequence {
	public int factorial(int x)
	{
		if(x <= 0)
			return -1;
		if(x == 1)
			return 1;
		else
			return x*factorial(x - 1);
		
	}
	/**
	 *时间复杂度为O(n),注意边界情况 
	 */
	public String getPermutation(int n,int k)
	{
		ArrayList<Integer> al = new ArrayList<>();
		StringBuilder result = new StringBuilder("");
		int tmp = factorial(n - 1);
		int tmp_e = n - 1;
		int total = k;
		for(int i = 1;i <= n;i++)
			al.add(i);
		while(al.size()>1)			//注意这里,如果以size()>0为条件,tmp有可能出问题(如n=1,k=1)
		{
			System.out.println();
			if(total % tmp == 0)
			{
				int location = total / tmp - 1;
				result.append(al.get(location));
				al.remove(location);
				break;
			}
			else
			{	
				int location = total / tmp;
				result.append(al.get(location));
				al.remove(location);
				total %= tmp;
				tmp /= tmp_e;
				tmp_e -= 1;
			}
		}
		for(int i = al.size() - 1;i >= 0;i--)
			result.append(al.get(i));
		return result.toString();
	}
	public static void main(String[] args) {
		String s = new PermutationSequence().getPermutation(1,1);
		System.out.println(s);
	}

}
