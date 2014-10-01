package leetcode;

class Producer implements Runnable{
	private Clerk clerk;
	public Producer(Clerk clerk)
	{
		this.clerk = clerk;
	}
	@Override 
	public void run()		//生产者生产数字
	{
		for(int i = 1;i <= 10;i++)
		{
			try{
				Thread.sleep((int)(Math.random() * 1000));
				System.out.println("生产者生产数字:" + i);
				clerk.setProduct(i);						//生产者将数字传递给clerk
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	private Clerk clerk;
	private int product;
	public Consumer(Clerk clerk)
	{
		this.clerk = clerk;
	}
	@Override
	public void run()
	{
		for(int i = 1;i <= 10;i++)
		{
			this.product = clerk.getProduct();			//消费者从clerk处取得数字
			System.out.println("消费者消费数字:" + this.product);
		}
	}
}

class Clerk{
	private int product = -1;
	public synchronized void setProduct(int x)
	{
		while(this.product != -1)
		{
			try{
				wait();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		this.product = x;
		System.out.println("生产者-->clerk");
		notify();
	}
	public synchronized int getProduct()
	{	
		int p = 0;
		while(product == -1)
		{
			try{
				wait();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		p = this.product;
		this.product = -1;
		System.out.println("clerk-->消费者");
		notify();
		return p;
	}
	
}


public class _ProduceConsumer {
	public static void  main(String[] args){
		Clerk clerk = new Clerk();
		Producer t1 = new Producer(clerk);
		Consumer t2 = new Consumer(clerk);
		new Thread(t1).start();
		new Thread(t2).start();
	}
}
