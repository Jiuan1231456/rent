package com.example.rent.task;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component // 將此類別交給spring boot託管成元件類，此class註冊成為bean之後才能啟動排成
//bean:被spring boot託管成類別/介面...等之統稱
//會將此類別託管為元件是因為此類別 不屬於 Controller、Service、Entity等範疇
//@EnableScheduling // 讓方法中的@Scheduled生效(如果沒有這個就算你執行也不會有東西出來)
//@EnableScheduling通常是加在一班類別和啟動類別上(Application.java)，通常會加在啟動類別上面
public class ScheduleTask {

//@Scheduled(fixedRate = 5000) // 單位:ms 每隔 x ms 印出東西
//@Scheduled(fixedRateString =  "${aaa}")  
//  ${aaa}  =>這裡的aaa寫在了 src/main...application
//使用${key} 可以取得application.propertise中key對應的value(格式是key=value)
// key 是自訂義命名，通常是有義意命名
//@Scheduled(cron = "0 0 10 * * ?")//早上十點
//@Scheduled(cron = "0 * 14 * * ?")//每天14點每分鐘執行
//@Scheduled(cron = "0 0/5 14-16 * * ?")//每天的14點到16點間，每5分鐘執行一次
//	@Scheduled(cron = "0/15 * 14 * * ?") // 每天14點，每15秒執行一次
//	public void fixedRate() {
//		System.out.println(LocalDateTime.now());
//	}

}