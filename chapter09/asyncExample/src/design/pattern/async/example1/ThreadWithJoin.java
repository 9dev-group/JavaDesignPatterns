package design.pattern.async.example1;

//쓰레드를 join을 이용하여 제어 가능
//해당 쓰레드가 종료되기까지 기다렸다가 다음으로 넘어감
public class ThreadWithJoin {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "start");
		Runnable r = new MyRunnable();
		Thread thread = new Thread(r);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "end");
	}
}

