package leetcode;
import java.util.Arrays;
import java.util.Stack;

import SortAlgorithm.QuickSort;

public class LargestRectangleInHistogram {
	/**
	 * 此方法在极端情况下时间复杂度为(n^2),(leetcode上超时)
	 * 
	 */
	public int largestRectangleAreaV1(int[] height)
	{
		int maxAll = 0;
		for(int i = 0;i < height.length;i++)
		{
			int tmp = 0;
			int p = i - 1;
			int q = i;
			while(p >= 0 && height[p] >= height[i])
			{
				tmp += height[i];
				p--;
			}
			while(q < height.length && height[q] >= height[i])
			{
				tmp += height[i];
				q++;
			}
			if(tmp > maxAll)
			{
				maxAll = tmp;
			}
			
			
		}
		return maxAll;
	}
	
	
	/**
	 * V2分治算法实现，避免了V1中全相等情况下的超时，但在数组中数很大时仍有很高时间复杂度(leetcode上超时)，因为merge部分循环递减变量是1!
	 * (可以想象V1也面临这个问题)
	 * 
	 */
	public int largestRectangleAreaV2(int[] height)
	{
		return findLargest(height,0,height.length - 1);
	}
	public int findLargest(int[] height,int low,int high)
	{
		if(low < high)
		{
			int mid = (low + high) / 2;
			int former = findLargest(height,low,mid);
			int post = findLargest(height,mid + 1,high);
			int middle = merge(height,low,high);
			if(former > post && former > middle)
				return former;
			else if(middle > former && middle > post)
				return middle;
			else
				return post;
		}
		if(low == high)
			return height[low];
		else
			return 0;
	}
	public int merge(int[] height,int low,int high)
	{
		int mid = (low + high) / 2;
		int p = (height[mid] < height[mid + 1])?mid:mid+1;
		if(height[p] == 1)
			return 0;
		int i = p - 1,j = p;
		int tmp = 0;
		int max = 0;
		for(int k = height[p];k >= 1;k--)
		{
			i = p - 1;
			j = p;
			tmp = 0;
			while(i >= low && height[i] >= k)
			{
				tmp += k;
				i --;
			}
			while(j <= high && height[j] >=k)
			{
				tmp += k;
				j++;
			}
			if(tmp > max)
				max = tmp;
		}
		return max;
	}
	
	/**
	 *V3分治，改进了V2中循环递减变量为1的高时间复杂度
	 */
	public int largestRectangleAreaV3(int[] height)
	{
		int[] tmpArray = Arrays.copyOfRange(height, 0, height.length);
		new QuickSort().quickSort(tmpArray, 0, tmpArray.length - 1);
//		Arrays.sort(tmpArray);
		return findLargestV2(height,0,height.length - 1,tmpArray);
	}
	public int findLargestV2(int[] height,int low,int high,int[] tmpArray)
	{
		if(low < high)
		{
			int mid = (low + high) / 2;
			int former = findLargestV2(height,low,mid,tmpArray);
			int post = findLargestV2(height,mid + 1,high,tmpArray);
			int middle = mergeV2(height,low,high,tmpArray);
			if(former > post && former > middle)
				return former;
			else if(middle > former && middle > post)
				return middle;
			else
				return post;
			
		}
		if(low == high)
			return height[low];
		else
			return 0;
	}
	public int mergeV2(int[] height,int low,int high,int[] tmpArray)
	{
		int mid = (low + high) / 2;
		int p = (height[mid] < height[mid + 1])?mid:mid+1;
		if(height[p] == 0)
			return 0;
		int i = p - 1,j = p;
		int tmp = 0;
		int max = 0;
		int location = Arrays.binarySearch(tmpArray, height[p]);
		
		for(int k = location;k >= 0;k--)
		{
			while(k > 0 && tmpArray[k] == tmpArray[k - 1])	//去重，若遇重复值则跳过
				k--;
				i = p - 1;
				j = p;
				tmp = 0;
				while(i >= low && height[i] >= tmpArray[k])		
				{
					tmp += tmpArray[k];
					i --;
				}
				while(j <= high && height[j] >=tmpArray[k])
				{
					tmp += tmpArray[k];
					j++;
				}
				if(tmp > max)
					max = tmp;
		}
		return max;
	}	

	/**
	 * V4来自网上，两个栈，很巧妙
	 * 原理:寻找每个"驼峰",在"驼峰"内寻找局部最大,最后得出全局最大值
	 * "驼峰":右边界容易得到，左边界必须比右边界高(否则无法保证右边不可扩展)<--关键
	 * 人为在数组末尾添加一个最小数(防止漏掉最后一步操作else)
	 */
	public int largestRectangleAreaV4(int[] height)
	{
		if(height.length == 0)
			return 0;
		int[] height1 = Arrays.copyOfRange(height,0, height.length + 1);
		height1[height1.length - 1] = -1;
		Stack<Integer> value = new Stack<Integer>();
		Stack<Integer> point = new Stack<Integer>();
		int maxAll = 0;
		for(int i = 0;i < height1.length;i++)
		{
			if(point.isEmpty() || height1[i] >= value.peek())
			{
				value.push(height1[i]);
				point.push(i);
			}
			else
			{	
				int tmp = 0;
				int location = 0;
				int min = Integer.MAX_VALUE;
				do
				{
					tmp = value.pop();
					location = point.pop();
					min = min < tmp ? min : tmp;
					maxAll = maxAll > min * (i - location) ? maxAll : min * (i - location);
					//System.out.printf("maxAll:%d min:%d i:%d location:%d%n",min * (i - location),min,i,location);
				}
				while(!value.isEmpty() && value.peek() >= height1[i]);
				value.push(height1[i]);
				point.push(location);
			}
			
		}
		return maxAll;
	}
}