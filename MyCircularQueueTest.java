package hw8_1;

import java.util.Scanner;

public class MyCircularQueueTest
{
	public static void main(String[] args)
	{
		System.out.println("hw8_1: 최태훈");
		MyCircularQueue queue = new MyCircularQueue(5);
		Scanner input = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요");
		int menu = 0;
		int value=0; 
		
		do {
			System.out.println("1.삽입 2.삭제 3.전체 삭제 4.종료--->");
			menu = input.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("삽입할 원소:");
				value = input.nextInt();
				queue.enQueue(value);
				break;
			case 2:
				System.out.println("삭제한 원소:");
				System.out.println(queue.deQueue());	
				break;
			case 3:
				if(queue.isEmpty())
				{
					System.out.println("원소가 비어있습니다");
				}
				else
				{
					System.out.println("전체 삭제합니다");
					while(queue.isEmpty() == false)
						System.out.print(queue.deQueue()+" ");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("종료합니다");
				break;
			}
		}while(menu!= 4);
	}
}
