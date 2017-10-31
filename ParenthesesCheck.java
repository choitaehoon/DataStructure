package hw7_1;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesCheck 
{ // 일단 ()먼저 해보기
	
	public static void main(String[] args)  
	{
		System.out.println("hw7_1:최태훈");
		Scanner input = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		
		String a;// 값입력
		char b = 0;//값저장변수
		String c;// pop 저장 변수

		System.out.println("괄호식 입력:");
		a = input.next();

		for(int i=0; i<a.length(); i++)
		{
			b = a.charAt(i);
			
			switch(b)
			{
			case '(': stack.push("("); break;
			case '{': stack.push("{"); break;
			case '[': stack.push("["); break;
			case '<': stack.push("<"); break;
			
			case ')':
				if(stack.size() == 0)
				{
					System.out.println("잘못된 수식입니다");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "(")
					{
					System.out.println("잘못된 수식입니다");
					System.exit(0);
					}
					
				}
				break;
			case '}' :
				if(stack.size() == 0)
				{
					System.out.println("잘못된 수식입니다");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "{")
					{
						System.out.println("잘못된 수식입니다");
						System.exit(0);
					}

				}
				break;
			case ']' :
				if(stack.size() == 0)
				{
					System.out.println("잘못된 수식입니다");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "[")
					{
						System.out.println("잘못된 수식입니다");
						System.exit(0);
					}
				}
				break;
			case '>' :
				if(stack.size() == 0)
				{
					System.out.println("잘못된 수식입니다");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "<")
					{
						System.out.println("잘못된 수식입니다");
					System.exit(0);
					}
				}
				break;
				
			}
		}
	
		if(stack.isEmpty() != true)
			System.out.println("잘못된 수식입니다");
		else
			System.out.println("올바른 수식입니다");
		
	}
}
