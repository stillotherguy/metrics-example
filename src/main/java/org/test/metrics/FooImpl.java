package org.test.metrics;

import com.codahale.metrics.annotation.Timed;

public class FooImpl implements Foo {

	@Override
	@Timed(name = "Foo.qps.time")
	public void qps() {
		System.out.println("qps");
	}

	@Override
	public void tps() {
		System.out.println("tps");
	}

	@Override
	public void currentQuery() {
		System.out.println("currentQuery");
	}

	@Override
	public void totalTransaction() {
		System.out.println("totalTransaction");
	}

}
