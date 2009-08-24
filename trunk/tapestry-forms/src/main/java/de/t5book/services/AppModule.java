package de.t5book.services;

import java.io.IOException;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.Translator;
import org.apache.tapestry5.Validator;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.apache.tapestry5.upload.services.UploadSymbols;
import org.slf4j.Logger;

import de.t5book.services.impl.AlphanumericValidator;
import de.t5book.services.impl.CurrencyTranslator;
import de.t5book.services.impl.HasDigits;

public class AppModule {

	public void contributeValidationMessagesSource(
			OrderedConfiguration<String> configuration) {
		configuration.add("MyValidationMessages",
				"de/t5book/services/impl/ValidationMessages", "after:Default");
	}

	public static void contributeFieldValidatorSource(
			MappedConfiguration<String, Validator> configuration) {
		configuration.add("alphanumeric", new AlphanumericValidator());
		configuration.add("hasdigits", new HasDigits());
	}

	public static void contributeTranslatorSource(
			final Configuration<Translator> configuration) {
		configuration.add(new CurrencyTranslator());

	}

	public static void contributeApplicationDefaults(
			MappedConfiguration<String, String> configuration) {

		// The factory default is true but during the early stages of an
		// application
		// overriding to false is a good idea. In addition, this is often
		// overridden
		// on the command line as -Dtapestry.production-mode=false
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");

		configuration.add(UploadSymbols.REPOSITORY_THRESHOLD, "5120");
		configuration.add(UploadSymbols.REPOSITORY_LOCATION, System
				.getProperty("java.io.tmpdir"));
		configuration.add(UploadSymbols.REQUESTSIZE_MAX, "-1");
		configuration.add(UploadSymbols.FILESIZE_MAX, "1048576");
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
