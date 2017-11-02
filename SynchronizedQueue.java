package lab8_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue {
	private final Lock lock = new ReentrantLock(); //��ݱ��
	private final Condition notFull  = lock.newCondition(); //���� ���� 
	private final Condition notEmpty = lock.newCondition(); //���� ����
	private int[] array; 
	private int capacity;
	private int front = 0; //�Ǿ�
	private int rear = 0; //�ǵ�
	
	public SynchronizedQueue(int capacity) { 
		this.capacity = capacity;
		array = new int[capacity];
	}

	public boolean isEmpty() { //����ִ°� Ȯ���ϴ� �޼ҵ�
		return front == rear;
	}
	
	public boolean isFull() { //�������� Ȯ���ϴ� �޼ҵ�
		return (rear + 1) % capacity == front;
	}

	public void enQueue(int item) throws InterruptedException {
		lock.lock(); //�ٸ� �����尡 �������� ���ϵ��� lock �Ǵ�
		try {
			while (isFull()) {
				System.out.println("enQueue : ť�� �������� ��ٸ��ϴ�.");
				notFull.await(); //notFull�� ����ϰ� �־��
			}
			rear = (rear + 1) % capacity;
			array[rear] = item;
			notEmpty.signal(); //notEmpt���� ����ϴ� �͵��� ������  ����� �ض�
		} finally {
			lock.unlock(); //lock�� Ǯ� �ٸ� �����尡 ���� �� �� �ֵ��� �Ѵ�.
		}
	}

	public int deQueue() throws InterruptedException {
		lock.lock(); //�ٸ� �����尡 �������� ���ϵ��� lock�Ǵ�
		try {
			while (isEmpty()) {
				System.out.println("\t\tdeQueue : ť�� �� ��ٸ��ϴ�.");
				notEmpty.await(); //notEmpty�� ����ϰ� �־�� 
			}
			front = (front + 1) % capacity;
			int item = array[front];
			notFull.signal(); //notFull�� ����ϴ� ���Ұ� ������ ����� �ض�
			return item;
		} finally {
			lock.unlock(); //lock�� Ǯ� �ٸ� �����尡 ���� �� �� �ֵ��� �Ѵ�.
		}
	}
}

