package com.lai.Schduled;

import com.lai.dao.userDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lailai on 2017/9/19.
 * 定时任务实现类
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Logger logger= LoggerFactory.getLogger(ScheduledTasks.class);
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("现在时间:"+format.format(new Date()));
    }

    @Autowired
    private userDao userDao;
    private static int num=0;
    @Scheduled(fixedRate = 10000)
    public void InsertUser(){
        if(num<=100){
            num++;
            logger.info("************" + num + "次插入数据开始,时间时:" + format.format(new Date()) + "**************");
            userDao.insert();
            logger.info("****************"+num+"次插入数据成功时间时:"+format.format(new Date())+"***********");
        }
    }
}
