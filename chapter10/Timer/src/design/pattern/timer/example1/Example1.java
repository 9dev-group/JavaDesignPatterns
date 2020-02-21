package design.pattern.timer.example1;

import java.util.Timer;
import java.util.TimerTask;

public class Example1 {

	public static void main(String[] args){
		Timer timer = new Timer();
		TimerTask task1 = new TimerTask(){
			@Override
			public void run() {
				System.out.println("tes1");
			}
		};
		
		TimerTask task2 = new TimerTask(){
			@Override
			public void run() {
				System.out.println("test2");
			}
		};
		
		//단발성 실행
		timer.schedule(task1, 1000);
		//연발성 실행
		timer.schedule(task2, 1000, 1000);
	}
}
