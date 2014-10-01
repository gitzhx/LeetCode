package leetcode;

class Key{
	public int plate = 0;
}

class Producer2 implements Runnable{
	private Key key;
	public Producer2(Key key)
	{
		this.key = key;
	}
	@Override 
	public void run()
	{
		for (int i = 1; i <= 100; i++) {
			synchronized (key) {
				while (key.plate != 0) {
					try {
						key.wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}

				try {
					Thread.sleep((int) (Math.random() * 10));
					System.out.println("生产者生产出第" + i + "块pizza...");
					key.plate++;
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				key.notify();
			}
		}
	}
}
class Consumer2 implements Runnable{
	private Key key;
	public Consumer2(Key key)
	{
		this.key = key;
	}
	@Override
	public void run()
	{
		for (int i = 1; i <= 100; i++) {
			synchronized (key) {
				while (key.plate != 1) {
					try {
						key.wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}

				try {
					Thread.sleep((int) (Math.random() * 10));
					System.out.println("消费者消费第" + i + "块pizza...");
					key.plate--;
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				key.notify();
			}
		}
	}
}


public class _ProduceConsumer2 {
	
	public static void main(String[] args) {
		Key key = new Key();
		Producer2 t1 = new Producer2(key);
		Consumer2 t2 = new Consumer2(key);
		new Thread(t1).start();
		new Thread(t2).start();
	}

}
