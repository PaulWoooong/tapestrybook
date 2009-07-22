package de.t5book.services;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.services.Coercion;
import org.apache.tapestry5.ioc.services.CoercionTuple;
import org.apache.tapestry5.services.BeanBlockContribution;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;

import de.t5book.pages.AppPropertyDisplayBlocks;
import de.t5book.pages.AppPropertyEditBlocks;
import de.t5book.services.impl.BookServiceImpl;

/**
 * This module is automatically included as part of the Tapestry IoC Registry,
 * it's a good place to configure and extend Tapestry, or to place your own
 * service definitions.
 */
public class AppModule {
	public static void bind(ServiceBinder binder) {

		binder.bind(BookService.class, BookServiceImpl.class);
	}

	public static void contributeApplicationDefaults(
			MappedConfiguration<String, String> configuration) {

		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
	}

	public static void contributeDefaultDataTypeAnalyzer(
			MappedConfiguration<Class, String> configuration) {
		configuration.add(Calendar.class, "calendar");
	}

	public static void contributeBeanBlockSource(
			final Configuration<BeanBlockContribution> configuration) {
		BeanBlockContribution editBlock = new BeanBlockContribution("calendar",
				AppPropertyEditBlocks.class.getSimpleName(), "calendarBlock",
				true);
		BeanBlockContribution displayBlock = new BeanBlockContribution(
				"calendar", AppPropertyDisplayBlocks.class.getSimpleName(),
				"calendarBlock", false);
		
		configuration.add(editBlock);
		configuration.add(displayBlock);
	}

	public static void contributeTypeCoercer(
			Configuration<CoercionTuple> configuration) {

		Coercion<Date, Calendar> dateToCalendar = new Coercion<Date, Calendar>() {

			public Calendar coerce(Date input) {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(input);
				return calendar;
			}
		};

		Coercion<Calendar, Date> calendarToDate = new Coercion<Calendar, Date>() {

			public Date coerce(Calendar input) {
				return input.getTime();
			}

		};

		add(configuration, Date.class, Calendar.class, dateToCalendar);

		add(configuration, Calendar.class, Date.class, calendarToDate);

	}

	private static <S, T> void add(Configuration<CoercionTuple> configuration,
			Class<S> sourceType, Class<T> targetType, Coercion<S, T> coercion) {
		CoercionTuple<S, T> tuple = new CoercionTuple<S, T>(sourceType,
				targetType, coercion);

		configuration.add(tuple);
	}

	/**
	 * This is a service definition, the service will be named "TimingFilter".
	 * The interface, RequestFilter, is used within the RequestHandler service
	 * pipeline, which is built from the RequestHandler service configuration.
	 * Tapestry IoC is responsible for passing in an appropriate Logger
	 * instance. Requests for static resources are handled at a higher level, so
	 * this filter will only be invoked for Tapestry related requests.
	 * 
	 * <p>
	 * Service builder methods are useful when the implementation is inline as
	 * an inner class (as here) or require some other kind of special
	 * initialization. In most cases, use the static bind() method instead.
	 * 
	 * <p>
	 * If this method was named "build", then the service id would be taken from
	 * the service interface and would be "RequestFilter". Since Tapestry
	 * already defines a service named "RequestFilter" we use an explicit
	 * service id that we can reference inside the contribution method.
	 */
	public RequestFilter buildTimingFilter(final Logger log) {
		return new RequestFilter() {
			public boolean service(Request request, Response response,
					RequestHandler handler) throws IOException {
				long startTime = System.currentTimeMillis();

				try {
					// The responsibility of a filter is to invoke the
					// corresponding method
					// in the handler. When you chain multiple filters together,
					// each filter
					// received a handler that is a bridge to the next filter.

					return handler.service(request, response);
				} finally {
					long elapsed = System.currentTimeMillis() - startTime;

					log.info(String.format("Request time: %d ms", elapsed));
				}
			}
		};
	}

	/**
	 * This is a contribution to the RequestHandler service configuration. This
	 * is how we extend Tapestry using the timing filter. A common use for this
	 * kind of filter is transaction management or security. The
	 * 
	 * @Local annotation selects the desired service by type, but only from the
	 *        same module. Without
	 * @Local, there would be an error due to the other service(s) that
	 *         implement RequestFilter (defined in other modules).
	 */
	public void contributeRequestHandler(
			OrderedConfiguration<RequestFilter> configuration,
			@Local RequestFilter filter) {
		// Each contribution to an ordered configuration has a name, When
		// necessary, you may
		// set constraints to precisely control the invocation order of the
		// contributed filter
		// within the pipeline.

		configuration.add("Timing", filter);
	}
}
