package hw8_2;
import java.util.Scanner;

public class MyLinkedQueueTest
{
	public static void main(String[] args)
	{
		System.out.println("hw8_2:������");
		Scanner input = new Scanner(System.in);
		MyLinkedQueue queue = new MyLinkedQueue();
		
		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int value = 0;
		
		do {
			System.out.println("1.���� 2.���� 3.��ü ���� 4.����--->");
			menu = input.nextInt();
			
			switch(menu)
			{
			case 1:
				System.out.println("������ ���Ҹ� �Է��ϼ���");
				value = input.nextInt();
				queue.enQueue(value);
				break;
			case 2:
				System.out.println("������ ����");
				System.out.println(queue.deQueue());
				break;
			case 3:
				if(queue.isEmpty())
					System.out.println(queue.deQueue()+"���Ұ� ������ϴ�");
				else
				{
					System.out.println("��ü ���� �մϴ�");
					while(queue.isEmpty() != true)
						System.out.print(queue.deQueue()+" ");
					System.out.println();
				}
				break;
			case 4 :
				System.out.println("�����մϴ�");
				break;
			}
			
		}while(menu != 4);
	}
}
