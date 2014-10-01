package leetcode;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s)
	{
		if(s == null || s.length() == 0)
			return 0;
		int i = s.length() - 1;
		int j;
		for(;i >= 0;i--)
			if(s.charAt(i) != ' ')
				break;
		if(i == 0)
			return 1;
		if(i < 0)
			return 0;
		else
		{
			for(j = i;j >=0;j--)
				if(s.charAt(j) == ' ')
					break;
			return i - j;
		}
	}
	
	public static void main(String[] args) {
		int len;
		String s = " as ";
		len = new LengthOfLastWord().lengthOfLastWord(s);
		System.out.println(len);
	}

}
