package lab8_1;

public class SynchronizedQueueTest {
	public static void main(String[] args) {
		System.out.println("lab8_1: 홍길동");

		// 크기 5인 원형 큐를 생성
		SynchronizedQueue queue = new SynchronizedQueue(5);

		// 원형 큐를 공유하는 생산자 스레드, 소비자 스레드를 실행
		Thread producer = new ProducerThread(queue);
		Thread consumer = new ConsumerThread(queue);
		
		producer.start();
		consumer.start();

	}
}


class ProducerThread extends Thread {
	private SynchronizedQueue queue;

	public ProducerThread(SynchronizedQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 20; i++) {
			System.out.println(currentThread().getName() + ": " + i + " 생산"); 
			try {
				queue.enQueue(i);
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class ConsumerThread extends Thread {
	private SynchronizedQueue queue;

	public ConsumerThread(SynchronizedQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int sum = 0;
		try {
			sleep(3000);
			for(int i = 0; i < 20; i++) {
				int value = queue.deQueue();		
				System.out.println("\t\t\t" + currentThread().getName() + ": " + value + " 소비"); 
				sum += value;
				sleep((int) (Math.random() * 500));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("소비자가 계산한 정수 합 = " + sum);
	}
}

