package leetcode;

public class ImplementStrStr {
	/**
	 *直接使用String自带方法实现，属于暴利求解法，时间复杂度不算好
	 *substring方法是组合startswith实现的 
	 */
	public String strStr(String haystack,String needle)
	{
		int location = haystack.indexOf(needle);
		if(location == -1)
			return null;
		else
		{
			return haystack.substring(location);
		}
	}
	public static void main(String[] args) {
		String s = new ImplementStrStr().strStr("hello soft works","softt");
		System.out.println(s);
	}

}
