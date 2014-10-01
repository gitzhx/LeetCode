package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Anagrams {
	/**
	 *时间复杂度O(n),第一遍遍历排序单词并存入新的ArrayList，
	 *第二遍遍历将排序后单词存入字典并更新出现次数，
	 *第三次遍历根据字典里的value值判断单词是否是anagram 
	 */
	public ArrayList<String> anagrams(String[] strs)
	{
		ArrayList<String> sortedList = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		Map<String,Integer> sortedMap = new HashMap<>();
		for(String s:strs)
		{
			char[] tmp = s.toCharArray();
			Arrays.sort(tmp);
			sortedList.add(new String(tmp));
		}
		for(String s:sortedList)
		{
			if(!sortedMap.containsKey(s))
				sortedMap.put(s, 1);			//map的put函数可以进行覆盖操作，该函数返回值是该key覆盖前的value
			else
				sortedMap.put(s, sortedMap.get(s) + 1);
		}
		for(int i = 0;i < sortedList.size();i++)
		{
			if(sortedMap.get(sortedList.get(i)) > 1)
				result.add(strs[i]);
		}
		return result;
	}
	public static void main(String[] args) {
		String[] a = new String[]{"tea","and","ate","eat","den"};
		ArrayList<String> result = new Anagrams().anagrams(a);
		for(String s:result)
		{
			System.out.println(s);
		}
	}

}
