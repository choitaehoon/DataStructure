package hw8_2;

import java.util.NoSuchElementException;

public class MyLinkedQueue 
{
	private Node front;
	private Node rear;
	
	public MyLinkedQueue()
	{
		front = null;
		rear = null;
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	public void enQueue(int value)
	{
		Node newNode = new Node();
		newNode.data = value;
		
		if(isEmpty())
		{
			front = newNode;
			rear = newNode;
		}
		else
		{
			rear.link = newNode;
			rear = newNode;
		}
	}
	
	public int deQueue() throws NoSuchElementException
	{
		if(isEmpty())
		{
			System.out.println("���Ұ� ����ֽ��ϴ�");
			throw new NoSuchElementException();
		}
		else
		{
			int data = 0;// �������� �� ����
			data = front.data;
			front = front.link;
			if(front == null)
				rear = null;
			return data;
		}
			
	}
	
	private class Node
	{
		int data;
		Node link;
	}
}
