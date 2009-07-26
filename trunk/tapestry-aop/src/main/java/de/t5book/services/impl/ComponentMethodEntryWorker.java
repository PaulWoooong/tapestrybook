package de.t5book.services.impl;

import java.util.List;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.model.MutableComponentModel;
import org.apache.tapestry5.services.ClassTransformation;
import org.apache.tapestry5.services.ComponentClassTransformWorker;
import org.apache.tapestry5.services.ComponentMethodAdvice;
import org.apache.tapestry5.services.ComponentMethodInvocation;
import org.apache.tapestry5.services.MethodFilter;
import org.apache.tapestry5.services.TransformMethodSignature;

public class ComponentMethodEntryWorker implements ComponentClassTransformWorker {

	public void transform(ClassTransformation transformation,
			MutableComponentModel model) {

		List<TransformMethodSignature> signatures = transformation
				.findMethodsWithAnnotation(OnEvent.class);

		if (signatures.isEmpty())
			return;

		final String componentClass = transformation.getClassName();

		ComponentMethodAdvice advice = new ComponentMethodAdvice() {

			public void advise(ComponentMethodInvocation invocation) {
				System.out.println(String.format("Aufruf von %s.%s",
						componentClass, invocation.getMethodName()));
				invocation.proceed();

			}
		};

		for (TransformMethodSignature signature : signatures) {
			transformation.advise(signature, advice);
		}

	}
}
