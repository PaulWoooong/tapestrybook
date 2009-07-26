package de.t5book.services;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Invocation;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdvice;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Match;
import org.apache.tapestry5.services.ComponentClassTransformWorker;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;

import de.t5book.services.impl.AdderServiceImpl;
import de.t5book.services.impl.AuthorizationException;
import de.t5book.services.impl.AuthorizationServiceImpl;
import de.t5book.services.impl.ComponentMethodEntryWorker;
import de.t5book.services.impl.MyServiceImpl;
import de.t5book.services.impl.StringServiceImpl;

public class AppModule {

	public static void bind(ServiceBinder binder) {
		binder.bind(AdderService.class, AdderServiceImpl.class);
		binder.bind(AuthorizationService.class, AuthorizationServiceImpl.class);
		binder.bind(MyService.class, MyServiceImpl.class);
		binder.bind(StringService.class, StringServiceImpl.class);
	}

	@Match("*")
	public static void adviseAll(MethodAdviceReceiver receiver) {
		final Class interfaceClass = receiver.getInterface();

		MethodAdvice advice = new MethodAdvice() {
			public void advise(Invocation invocation) {
				System.out.println(String.format("Aufruf von %s.%s",
						interfaceClass.getName(), invocation.getMethodName()));

				invocation.proceed();
			}
		};

		receiver.adviseAllMethods(advice);
	}

	@Match("MyService")
	public static void adviseSecurity(MethodAdviceReceiver receiver,
			final AuthorizationService authorizationService) {

		MethodAdvice advice = new MethodAdvice() {
			public void advise(Invocation invocation) {
				if (authorizationService.isAuthorizedCall()) {
					invocation.proceed();
				} else {
					throw new AuthorizationException();
				}
			}
		};

		receiver.adviseAllMethods(advice);
	}

	@Match("AdderService")
	public static void adviseNonNull(MethodAdviceReceiver receiver) {

		MethodAdvice advice = new MethodAdvice() {
			public void advise(Invocation invocation) {
				for (int i = 0; i < invocation.getParameterCount(); i++) {
					Class type = invocation.getParameterType(i);
					if (type.equals(Integer.class)) {
						Object value = invocation.getParameter(i);
						if (value == null) {
							invocation.override(i, new Integer(0));
						}
					}
				}
				invocation.proceed();
			}
		};
		receiver.adviseAllMethods(advice);
	}

	@Match("StringService")
	public static void adviseNonNullString(MethodAdviceReceiver receiver) {

		MethodAdvice advice = new MethodAdvice() {
			public void advise(Invocation invocation) {

				invocation.proceed();

				if (invocation.getResult() == null) {
					invocation.overrideResult("");
				}
			}
		};
		for (Method method : receiver.getInterface().getMethods()) {
			if (method.getReturnType().equals(String.class)) {
				receiver.adviseMethod(method, advice);
			}
		}
	}

	public static void contributeComponentClassTransformWorker(
			OrderedConfiguration<ComponentClassTransformWorker> configuration) {
		configuration.add("ComponentMethodEntryWorker",
				new ComponentMethodEntryWorker());
	}

	public static void contributeApplicationDefaults(
			MappedConfiguration<String, String> configuration) {
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
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
			OrderedConfiguration<RequestFilter> configuration, @Local
			RequestFilter filter) {
		// Each contribution to an ordered configuration has a name, When
		// necessary, you may
		// set constraints to precisely control the invocation order of the
		// contributed filter
		// within the pipeline.

		configuration.add("Timing", filter);
	}

}
