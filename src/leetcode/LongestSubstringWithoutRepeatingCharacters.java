package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 *V1在leetcode上超时，问题以注解标出
	 */
	public int lengthOfLongestSubstringV1(String s)
	{
		if(s == null || s.length() == 0)
			return 0;
		Map<Character,Integer> record = new HashMap<>();
		char c;
		int location = 0;
		int tmp = 0;
		int maxLength = 0;
		for(int i = 0;i < s.length();i++)
		{
			c = s.charAt(i);
			if(record.containsKey(c))
			{
				location = record.get(c) + 1;
				record.put(c,i);
				i = location - 1;				//这里每次遇到某字符二次出现时遍历指针会倒回，有时间浪费，可改进
				record.clear();
				if(tmp > maxLength)
				{
					maxLength = tmp;
				}
				tmp = 0;
			}
			else
			{
				tmp++;
				record.put(c, i);
			}
		}
		return maxLength > tmp ? maxLength : tmp;
	}
	
	/**
	 *网上的方法,较V1改进在于每次碰到字符第二次出现时不需要清空table,且整个过程中不用倒回,时间复杂度为O(n)
	 */
	 public int lengthOfLongestSubstringV2(String s) {
	       if(s==null || s.isEmpty()==true)  
	            return 0;  
	          
	        int len = s.length();  
	        int res = 1;  
	        int start = 0, cur = 1;  
	        int position[] = new int[300];  
	        Arrays.fill(position, -1);  
	        position[s.charAt(0)] = 0;  
	          
	        while(cur < len){  
	            if(position[s.charAt(cur)] < start){  	//如果该字符上次出现在start之前
	                res = Math.max(cur-start+1, res);  
	                position[s.charAt(cur)] = cur;  
	            }  
	            else{  									//如果该字符在start之后已经出现过
	                start = position[s.charAt(cur)] + 1;  
	                res = Math.max(res, cur-start+1);  
	                position[s.charAt(cur)] = cur;  
	            }  
	            cur++;  
	        }
	        return res;  
	    }
	 
	 /**
	  *根据V2改进的V1 
	  */
	 public int lengthOfLongestSubstringV3(String s)
		{
			if(s == null || s.length() == 0)
				return 0;
			Map<Character,Integer> record = new HashMap<>();
			char c;
			int location = 0;
			int tmp = 0;
			int maxLength = 0;
			for(int i = 0;i < s.length();i++)
			{
				c = s.charAt(i);
				if(record.containsKey(c) && record.get(c) >= location)	//如果该字符在location之后出现过
				{
					maxLength = Math.max(maxLength,i - location);
					location = record.get(c) + 1;
					record.put(c,i);
					tmp = 1;
				}
				else
				{
					tmp++;
					record.put(c, i);
				}
			}
			return Math.max(maxLength, tmp);
		}
	public static void main(String[] args) {
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		int maxLength = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringV1(s);
		System.out.println(maxLength);
	}

}
