package com.lai;

import com.lai.properties.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
