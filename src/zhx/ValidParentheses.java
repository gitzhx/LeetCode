package zhx;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s)
	{
		if(s == null)				//处理边界情况
			return false;
		else if(s.length() == 0)
			return true;
		
		Stack<Character> st = new Stack<>();
		char[] tmp = s.toCharArray();	
		for(char a:tmp)
		{
			if(a == '(' || a == '[' || a == '{')
				st.push(new Character(a));
			else
			{
				try
				{
					if(a == ')' && st.pop().charValue() == '(')		//出现反括号时出现不匹配或栈已空时，则不满足括号规则
						continue;
					if(a == ']' && st.pop().charValue() == '[')
						continue;
					if(a == '}' && st.pop().charValue() == '{')
						continue;
					return false;
				}
				catch(Exception e)
				{
					return false;
				}
			}
		}
		if(st.empty())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("{}["));
	}

}
