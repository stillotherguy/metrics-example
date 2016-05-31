package org.test.metrics;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class SampleFilter extends Filter<ILoggingEvent> {

	@Override
	public FilterReply decide(ILoggingEvent event) {
		if ("metrics".equals(event.getLoggerName())) {
			return FilterReply.DENY;
		}
		
		return FilterReply.ACCEPT;
	}

}
