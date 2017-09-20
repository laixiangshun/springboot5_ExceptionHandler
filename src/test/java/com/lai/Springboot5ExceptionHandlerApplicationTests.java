package com.lai;

import com.lai.AsyncTask.Task;
import com.lai.properties.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot5ExceptionHandlerApplicationTests {

	@Test
	public void contextLoads() {
	}

	/**
	 * 测试注入自定义配置属性
	 */
	@Autowired
	private BlogProperties blogProperties;

	@Test
	public  void testProperties() throws Exception{
		System.out.println("**************开始测试**************");
		Assert.assertEquals(blogProperties.getName(), "程序员");
		Assert.assertEquals(blogProperties.getTitle(),"Spring boot教程");
		Assert.assertEquals(BlogProperties.getContent(),"自定义属性");
		Assert.assertEquals(blogProperties.getDes(),"程序员正在努力编写《Spring boot教程》");
		System.out.println("**************测试完成*******************");
	}

	@Autowired
	private Task task;
	@Test
	public void AsyncTest() throws Exception{
		long start=System.currentTimeMillis();

		Future<String> task1=task.doTaskOne();
		Future<String> task2=task.doTaskTwo();
		Future<String> task3=task.doTaskThree();

		while (true){
			if(task1.isDone() && task2.isDone() && task3.isDone()){
				break;//三个异步任务完成，退出循环
			}
			Thread.sleep(1000);
		}
		long end=System.currentTimeMillis();
		System.out.println("任务完成，总耗时："+(end-start)+"毫秒");
	}
}
