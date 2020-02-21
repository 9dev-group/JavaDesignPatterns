package design.pattern.timer.example2;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
 
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

//매 시간이 7초일 때 작업을 실행하는 예제
public class MainClass {
	public static void main(String[] args) {
      SchedulerFactory schedulerFactory = new StdSchedulerFactory();
      try{
    	  Scheduler sch = schedulerFactory.getScheduler();
    	  
    	  //실행 작업 지정
    	  JobDetail job = newJob(TestJob.class)
                  .withIdentity("jobName", Scheduler.DEFAULT_GROUP)
                  .build();
              
    	  //실행 시간 지정
          Trigger trigger = newTrigger()
                  .withIdentity("triggerName", Scheduler.DEFAULT_GROUP)
                  .withSchedule(cronSchedule("7 * * * * ?"))
                  .build();
                          
          sch.scheduleJob(job, trigger);
          sch.start();
      }catch(Exception e){
    	  e.printStackTrace();
      }
	}
}
