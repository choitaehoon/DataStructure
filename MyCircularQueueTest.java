package hw8_1;

import java.util.Scanner;

public class MyCircularQueueTest
{
	public static void main(String[] args)
	{
		System.out.println("hw8_1: ������");
		MyCircularQueue queue = new MyCircularQueue(5);
		Scanner input = new Scanner(System.in);
		System.out.println("�޴� ��ȣ�� �Է��ϼ���");
		int menu = 0;
		int value=0; 
		
		do {
			System.out.println("1.���� 2.���� 3.��ü ���� 4.����--->");
			menu = input.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("������ ����:");
				value = input.nextInt();
				queue.enQueue(value);
				break;
			case 2:
				System.out.println("������ ����:");
				System.out.println(queue.deQueue());	
				break;
			case 3:
				if(queue.isEmpty())
				{
					System.out.println("���Ұ� ����ֽ��ϴ�");
				}
				else
				{
					System.out.println("��ü �����մϴ�");
					while(queue.isEmpty() == false)
						System.out.print(queue.deQueue()+" ");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("�����մϴ�");
				break;
			}
		}while(menu!= 4);
	}
}
