package lab8_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue {
	private final Lock lock = new ReentrantLock(); //잠금기능
	private final Condition notFull  = lock.newCondition(); //조건 변수 
	private final Condition notEmpty = lock.newCondition(); //조건 변수
	private int[] array; 
	private int capacity;
	private int front = 0; //맨앞
	private int rear = 0; //맨뒤
	
	public SynchronizedQueue(int capacity) { 
		this.capacity = capacity;
		array = new int[capacity];
	}

	public boolean isEmpty() { //비어있는걸 확인하는 메소드
		return front == rear;
	}
	
	public boolean isFull() { //가득찬걸 확인하는 메소드
		return (rear + 1) % capacity == front;
	}

	public void enQueue(int item) throws InterruptedException {
		lock.lock(); //다른 스레드가 접근하지 못하도록 lock 건다
		try {
			while (isFull()) {
				System.out.println("enQueue : 큐가 가득차서 기다립니다.");
				notFull.await(); //notFull을 대기하고 있어라
			}
			rear = (rear + 1) % capacity;
			array[rear] = item;
			notEmpty.signal(); //notEmpt에가 대기하는 것들이 있으면  깨어나게 해라
		} finally {
			lock.unlock(); //lock을 풀어서 다른 스레드가 접근 할 수 있도록 한다.
		}
	}

	public int deQueue() throws InterruptedException {
		lock.lock(); //다른 스레드가 접근하지 못하도록 lock건다
		try {
			while (isEmpty()) {
				System.out.println("\t\tdeQueue : 큐가 비어서 기다립니다.");
				notEmpty.await(); //notEmpty을 대기하고 있어라 
			}
			front = (front + 1) % capacity;
			int item = array[front];
			notFull.signal(); //notFull에 대기하는 원소가 있으면 깨어나게 해라
			return item;
		} finally {
			lock.unlock(); //lock을 풀어서 다른 스레드가 접근 할 수 있도록 한다.
		}
	}
}

