package leetcode;

public class ReverseWorkInAString {
	public String reverseWords(String s) {
		String ss[] = s.split("\\s+");
		if(ss.length == 0)
			return "";
		StringBuilder result = new StringBuilder("");
		result.append(ss[ss.length-1]);
		for(int i = ss.length - 2;i >= 0;i--)
		{
			if(ss[i].length() > 0)
				result.append(" ").append(ss[i]);
		}
		return result.toString();
	}  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= " 1";
		System.out.println(new ReverseWorkInAString().reverseWords(s));
		
		
	}

}
