package design.pattern.timer.example1;

import java.util.Timer;
import java.util.TimerTask;

public class Example2 {

	public static int cnt;
	public static void main(String[] args){
		cnt = 0;
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){

			@Override
			public void run() {
				if(cnt < 5){
					System.out.println("test");
					cnt++;
				}else{
					timer.cancel();
				}
			}
		};
		
		timer.schedule(task, 1000, 1000);
	}
}
