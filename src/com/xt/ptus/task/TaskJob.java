package com.xt.ptus.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xt.ptus.mt.entity.MtTaskList;

/**
 * 定时任务类
 * 
 */
@Component()
public class TaskJob {

	private static Logger logger = Logger.getLogger(TaskJob.class);


	/**
	 * 每秒执行一次
	 */
	@Scheduled(cron = "*/1 * * * * ?")
	public void autoTask() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		List<MtTaskList> tasks = tlService.getList(sdf.format(new Date()));
//		if (tasks != null) {
//			for (MtTaskList task : tasks) {
//				try {
//					tlService.exeTask(task.getId());
//				} catch (Exception e) {
//					logger.error(e);
//				}
//			}
//		}
	}
}
