package leetcode;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;
import java.util.LinkedList;

class ClerkLock{
	private Queue<Integer> plates;
	private Lock lock;
	private Condition producerCondition;
	private Condition consumerCondition;
	public void setPlate(int x)
	{
		lock.lock();
		while(this.plates.size() >= 10)
		{
			try{
				producerCondition.await();
			}catch(InterruptedException ex){
				System.out.println("生产者阻塞错误！");
			}
		}
		plates.offer(new Integer(x));
		//System.out.println(x + ":生产者-->clerk");
		try{
			consumerCondition.signal();
		}catch(IllegalMonitorStateException ex){
			System.out.println("消费者唤醒错误！");
		}
		lock.unlock();
	}
	public int getPlate()
	{
		int result = 0;
		lock.lock();
		while(this.plates.size() <= 0)
		{
			try{
				consumerCondition.await();
			}catch(InterruptedException ex){
				System.out.println("消费者阻塞错误！");
			}
		}
		result = plates.poll();
		try{
			producerCondition.signal();
		}catch(IllegalMonitorStateException ex){
			System.out.println("生产者唤醒错误！");
		}
		lock.unlock();
		return result;
	}
	public ClerkLock()
	{
		this.plates = new LinkedList<Integer>();
		this.lock = new ReentrantLock();
		this.producerCondition = lock.newCondition();
		this.consumerCondition = lock.newCondition();
	}
}
class ProducerLock extends Thread{
	private ClerkLock clerk;
	
	public ProducerLock(ClerkLock clerk)
	{
		this.clerk = clerk;
	}
	@Override
	public void run()
	{
		
		for(int i = 1;i <= 100;i++)
		{
			try {
				Thread.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
			}
			System.out.println("生产者生产第" + i + "个数字...");
			clerk.setPlate(i);
		}
	}
}
class ConsumerLock extends Thread{
	private ClerkLock clerk;
	public ConsumerLock(ClerkLock clerk)
	{
		this.clerk = clerk;
	}
	@Override
	public void run()
	{
		int product = 0;
		for(int i = 1;i <= 100;i++)
		{
			try {
				Thread.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
			}
			product = clerk.getPlate();
			System.out.println("消费者消耗第" + product + "个数字...");
		}
	}
}
public class _ProducerConsumer2Lock {
	public static void main(String[] args)
	{
		ClerkLock clerk = new ClerkLock();
		ProducerLock pro = new ProducerLock(clerk);
		ConsumerLock con = new ConsumerLock(clerk);
		pro.start();
		con.start();
	}
}
