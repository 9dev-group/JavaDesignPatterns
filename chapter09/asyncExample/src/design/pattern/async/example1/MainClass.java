package design.pattern.async.example1;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
     Thread thread1 = new Thread(new AsyncRunnable());
     thread1.start();
     HelloThread thread2 = new HelloThread();
     System.out.println("11111111111111");
     Thread.sleep(2000);
     thread2.start();
     System.out.println("22222222222222");
	}

}
