package leetcode;
import java.util.List;
import java.util.ArrayList;

public class Combinations {
	/**
	 *完整考虑了边界情况
	 *递归地实现， 当n，k比较大时，递归众有非常多的"重叠子问题"
	 *因此，可以考虑动态规划，但动态规划空间开辟是个灾难。(只能看具体问题取舍)
	 *leetcode runtime:472ms
	 */
	public List<List<Integer>> combine(int n,int k)
	{
		List<List<Integer>> result1;
		List<List<Integer>> result2;
		if(k == 0)
		{
			result1 = new ArrayList<List<Integer>>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			result1.add(tmp);
			return result1;
		}
		else if(n == k)
		{
			result1 = new ArrayList<List<Integer>>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(int i = 1;i <= n;i++)
				tmp.add(i);			//自动装箱，减少变量创建
			result1.add(tmp);
			return result1;
		}
 		else if(n < k)
 		{
 			result1 = new ArrayList<List<Integer>>();
 			return result1;
 		}
 		else
 		{
 			result1 = combine(n-1,k);
 			result2 = combine(n-1,k-1);
 			for(List<Integer> tmp:result2)
 			{
 				tmp.add(n);			//自动装箱，减少变量创建
 				result1.add(tmp);
 			}
 			return result1;
 		}
	}
	/**
	 *直观地循环实现(几乎没有冗余步骤)
	 *逻辑有点绕，一个while循环：
	 *循环终止条件是number[1]或number[k]数值过界
	 *循环包括两个工作，1：将该number序列加入到result。2：从后向前调节序列值(关键)
	 *leetcode runtime:420ms
	 */
	public List<List<Integer>> combine2(int n,int k)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(!(n >= k && k >=0))					//如果n，k不符合条件，非法输入处理
		{
			result.add(new ArrayList<Integer>());
			return result;
		}
		int[] number = new int[k + 1];
		for(int i = 1;i <= k;i++)
			number[i] = i;
		while(number[1] <= n - k + 1 && number[k] <= n)			//第一层while循环
		{
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(int i = 1;i <= k;i++)							//将number序列add进result
				tmp.add(number[i]);
			result.add(tmp);
			if(number[k] < n)										//如果number[k]还没到n，则可+1继续
				number[k]++;
			else													//如果number[k]到了n，则要从后向前调整number中的值(这里面是关键)
			{
				int pre = k - 1;
				while(pre >=1 && number[pre] == number[pre + 1] - 1)
				{
					pre--;
				}
				if(pre == 0)
					break;
				else
				{
					int j;
					for(j = pre + 1,number[pre] += 1;j <= k;j++)
					{
						number[j] = number[j - 1] + 1;
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<List<Integer>> result = new Combinations().combine2(2, 1);
		for(List<Integer> tmp:result)
		{
			for(Integer i:tmp)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
