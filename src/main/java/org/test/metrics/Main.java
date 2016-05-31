package org.test.metrics;

import java.util.concurrent.TimeUnit;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		ctx.registerShutdownHook();
		Foo foo = ctx.getBean(Foo.class);
		for (int i = 0; i < 100; i++) {
			foo.currentQuery();
			foo.qps();
			foo.tps();
			foo.totalTransaction();
		}
		TimeUnit.DAYS.sleep(1);
	}

}
