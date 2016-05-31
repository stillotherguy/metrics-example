package org.test.metrics;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.FileDescriptorRatioGauge;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;

public class BaseTest {

	static final MetricRegistry metrics = new MetricRegistry();

	public static void main(String[] args) {
		startReport();
		Meter requests = metrics.meter("requests");
		requests.mark();
		//requests.mark();
		//metrics.register("jvm", new MemoryUsageGaugeSet());
		//mtrics.register("thread", new ThreadStatesGaugeSet());
		//merics.register("file", new FileDescriptorRatioGauge());
		wait5Seconds();
	}

	static void startReport() {
		ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).convertRatesTo(TimeUnit.MINUTES)
				.convertDurationsTo(TimeUnit.SECONDS).build();

		reporter.start(3, TimeUnit.SECONDS);
	}

	static void wait5Seconds() {
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
		}
	}
}
