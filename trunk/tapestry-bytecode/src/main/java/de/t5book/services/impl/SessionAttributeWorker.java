package de.t5book.services.impl;

import java.util.List;

import javassist.Modifier;

import org.apache.tapestry5.ioc.ObjectLocator;
import org.apache.tapestry5.model.MutableComponentModel;
import org.apache.tapestry5.services.ClassTransformation;
import org.apache.tapestry5.services.ComponentClassTransformWorker;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.TransformMethodSignature;

import de.t5book.annotations.SessionAttribute;

public class SessionAttributeWorker implements ComponentClassTransformWorker {

	private ObjectLocator objectLocator;

	public SessionAttributeWorker(ObjectLocator objectLocator) {
		super();
		this.objectLocator = objectLocator;
	}

	public void transform(ClassTransformation transformation,
			MutableComponentModel model) {
		List<String> names = transformation
				.findFieldsWithAnnotation(SessionAttribute.class);

		for (String fieldName : names) {
			SessionAttribute annotation = transformation.getFieldAnnotation(
					fieldName, SessionAttribute.class);

			String sessionKey = annotation.value();

			if ("".equals(sessionKey)) {
				sessionKey = fieldName;
			}

			String fieldType = transformation.getFieldType(fieldName);
			
			Request request = objectLocator.getService(Request.class);

			String requestField = transformation.addInjectedField(
					Request.class, "_request", request);

			replaceReadAccess(transformation, fieldName, fieldType, sessionKey, 
					requestField);
			replaceWriteAccess(transformation, fieldName, fieldType, sessionKey, 
							requestField);
		}
	}

	private void replaceReadAccess(ClassTransformation transformation,
			String fieldName, String fieldType, String sessionKey, 
			String requestField) {
		String readMethodName = transformation.newMemberName("read",
				fieldName);

		TransformMethodSignature readMethodSignature = new TransformMethodSignature(
				Modifier.PRIVATE, fieldType, readMethodName, null, null);
		
		
		String body = String.format(
				"return (%s) %s.getSession(true).getAttribute(\"%s\");",
				fieldType, requestField, sessionKey);
		
		transformation.addMethod(readMethodSignature, body);
		transformation.replaceReadAccess(fieldName, readMethodName);
	}
	
	private void replaceWriteAccess(ClassTransformation transformation,
			String fieldName,  String fieldType, String sessionKey,
			String requestField) {
		String writeMethodName = transformation.newMemberName("write",
				fieldName);

		TransformMethodSignature writeSignature = new TransformMethodSignature(
				Modifier.PRIVATE, "void", writeMethodName, new String[] { fieldType }, null);
		
		String body = String.format(
				"%s.getSession(true).setAttribute(\"%s\", $1);",
				requestField, sessionKey);
		
		transformation.addMethod(writeSignature, body);
		transformation.replaceWriteAccess(fieldName, writeMethodName);
		
	}

}
