package design.pattern.timer.example2;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("작업 실행 시간: "+ new Date(System.currentTimeMillis()));		
	}

}
