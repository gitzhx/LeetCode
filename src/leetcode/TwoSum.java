package leetcode;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Arrays;

class ValueLocation{
	int value;
	int location;
	public ValueLocation(int value,int location)
	{
		this.value = value;
		this.location = location;
	}
}

public class TwoSum {
	/**
	 * 时间复杂度O(nlogn)
	 *采用二分查找的思想，遍历numbers数组，对每个小于等于target的值，在其右半部分采取二分查找 
	 *要求数组已排序
	 */
	public int[] twoSumV1(int[] numbers,int target)
	{
		int[] result = new int[2];
		int tmp = 0;
		Arrays.fill(result,-1);
		for(int i = 0;numbers[i] <= target / 2 + 1 && i < numbers.length - 1;i++)
		{
			tmp = binarySearch(numbers,i + 1,numbers.length - 1,target - numbers[i]);
			if(tmp > 0)
			{
				result[0] = i + 1;
				result[1] = tmp + 1;
				break;
			}
		}
		return result;
	}
	public int binarySearch(int[] numbers,int low,int high,int target)
	{
		if(low > high)
			throw new ArrayIndexOutOfBoundsException();
		else
		{
			int mid;
			while(low <= high)
			{
				mid = (low + high) / 2;
				if(target == numbers[mid])
					return mid;
				else if(target < numbers[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
			return -low-1;
		}
	}
	
	/**
	 * 考虑情况，负数、两相等数
	 * 以数组值为下标构建新数组，三次遍历即可，时间复杂度为O(n)
	 */
	public int[] twoSumV2(int[] numbers,int target)
	{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] result = new int[2];
		Arrays.fill(result,-1);
		for(int i = 0;i < numbers.length;i++)
		{
			if(numbers[i] > max)
				max = numbers[i];
			if(numbers[i] < min)
				min = numbers[i];
		}
		ValueLocation[] values = new ValueLocation[max - min + 1];
		for(int i = 0;i < numbers.length;i++)
		{
			numbers[i] -= min;
		}
		target -= min * 2;
		for(int i = 0;i < numbers.length;i++)
		{
			if(target - numbers[i] >=0 && target - numbers[i] < values.length && values[target - numbers[i]] != null)
			{
				result[0] = i < values[target - numbers[i]].location?i + 1 : values[target - numbers[i]].location + 1;
				result[1] = i > values[target - numbers[i]].location?i + 1 : values[target - numbers[i]].location + 1;
				break;
			}
			else
			{
				values[numbers[i]] = new ValueLocation(numbers[i],i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{0,4,3,0};
		int target = 0;
		int[] result = new TwoSum().twoSumV2(A, target);
		System.out.println(result[0] + " " + result[1]);
	}

}
