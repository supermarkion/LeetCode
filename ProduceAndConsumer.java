import java.util.Random;

class Producer extends Thread {
	private static final int MAX_CAPACITY = 8;
	private staic final int RANDOM_RANGE = 128;
	private int[] buffer;
	private int index;
	private Random generator;

	public Producer()
	{
		buffer = new int[MAX_CAPACITY];
		generator = new Random(23);
		index = 0;	// initally empty
	}

	public void run()
	{
		while (true) {
			try {
				putInt();
			} catch (InterruptedException e) {

			}
		}
	}

	private synchronized void putInt() throws InterruptedException
	{
		while (index == MAX_CAPACITY) {			// Buffer is full
			wait();
		}
		buffer[index] = generator.nextInt(RANDOM_RANGE);
		index++;
		notifyAll();							// Let other threads know that something has happened
	}

	// Called by the consumer
	public synchronized int genInt() throws InterruptedException
	{
		notifyAll();							// Need to make sure that we're not stuck with this thread.
		while (index <= 0) {
			wait();
		}

		index--;
		return buffer[index];
	}
}

class Consumer extends Thread {
	private Producer producter;

	public Consumer(Producer theProducer)
	{
		producter = theProducer;
	}

	public void run()
	{
		try {
			while (true) {
				System.out.println("Int is " + producter.genInt());
			}
		} catch (InterruptedException e) {

		}
	}

	public static void main(String args[]) {
		Producer producter = new Producer();
		producter.run();
		new Consumer(producer).run();
	}
}