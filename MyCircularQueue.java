package hw8_1;

import java.util.NoSuchElementException;

public class MyCircularQueue
{
	int [] array;
	int front, rear = 0;
	
	public MyCircularQueue(int value)
	{
		array = new int[value];
	}
	
	public boolean isEmpty()
	{
		return front == rear;
	}
	
	public boolean isFull()
	{
		return (((rear+1) % array.length) == front);
	}
	
	public void enQueue(int value)
	{
		if(isFull())
		{
			System.out.println("���Ұ� �������ֽ��ϴ�");
		}
		else
		{
			rear = (rear+1) % array.length;
			array[rear] = value;
		}
	}
	
	public int deQueue() throws NoSuchElementException
	{
		if(isEmpty())
		{
			System.out.println("���Ұ� ��� �ֽ��ϴ�");
			throw new NoSuchElementException();
		}
		else
		{
			front = (front+1) % array.length;
			return array[front];
		}
	}
}
