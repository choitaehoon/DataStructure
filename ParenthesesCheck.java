package hw7_1;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesCheck 
{ // �ϴ� ()���� �غ���
	public static void main(String[] args)  
	{
		System.out.println("hw7_1:������");
		Scanner input = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		
		String a;// ���Է�
		char b = 0;//�����庯��
		String c;// pop ���� ����

		System.out.println("��ȣ�� �Է�:");
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
					System.out.println("�߸��� �����Դϴ�");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "(")
					{
					System.out.println("�߸��� �����Դϴ�");
					System.exit(0);
					}
					
				}
				break;
			case '}' :
				if(stack.size() == 0)
				{
					System.out.println("�߸��� �����Դϴ�");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "{")
					{
						System.out.println("�߸��� �����Դϴ�");
						System.exit(0);
					}

				}
				break;
			case ']' :
				if(stack.size() == 0)
				{
					System.out.println("�߸��� �����Դϴ�");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "[")
					{
						System.out.println("�߸��� �����Դϴ�");
						System.exit(0);
					}
				}
				break;
			case '>' :
				if(stack.size() == 0)
				{
					System.out.println("�߸��� �����Դϴ�");
					System.exit(0);
				}
				else
				{
					c = stack.pop();
					if(c != "<")
					{
						System.out.println("�߸��� �����Դϴ�");
					System.exit(0);
					}
				}
				break;
				
			}
		}
	
		if(stack.isEmpty() != true)
			System.out.println("�߸��� �����Դϴ�");
		else
			System.out.println("�ùٸ� �����Դϴ�");
		
	}
}
