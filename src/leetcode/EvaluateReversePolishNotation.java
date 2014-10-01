package leetcode;

public class EvaluateReversePolishNotation {
	public static int MAX = 100;
	public int evalRPN(String[] tokens)
	{
		//todoy是否应该加个判断，N0=N2 + 1？
		int[] number = new int[100];
		int n = 0;
		int a,b;
		for(int i=0;i < tokens.length;i++)
		{
			if(tokens[i].length() > 1 || tokens[i].charAt(0) >= '0' && tokens[i].charAt(0) <= '9')
			{
				number[n++] = Integer.parseInt(tokens[i]);
			}
			else
			{
				b = number[--n];
				a = number[--n];
				switch (tokens[i].charAt(0))
				{
					case '+':
						number[n++] = a + b;
						break;
					case '-':
						number[n++] = a - b;
						break;
					case '*':
						number[n++] = a * b;
						break;
					case '/':
						number[n++] = a / b;
						break;
				}
				
			}
		}
		return number[--n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] notation = {"2", "1", "+", "3", "*"};
		System.out.println(new EvaluateReversePolishNotation().evalRPN(notation));
	}

}
