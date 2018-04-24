package com.ljk.task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class TestTask {
	@Scheduled(cron="0/300 * * * * ? ") //间隔5秒执行
    public void taskCycle(){
        System.out.println("testTask");
    }
}
