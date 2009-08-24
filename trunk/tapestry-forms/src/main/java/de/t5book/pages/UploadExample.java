package de.t5book.pages;

import java.io.File;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.upload.services.UploadedFile;

public class UploadExample {
	@Property
	private UploadedFile uploadedFile;

	@Persist(PersistenceConstants.FLASH)
	@Property
	private String uploadErrorMessage;

	public void onSuccess() {

		String tempDir = System.getProperty("java.io.tmpdir");

		File file = new File(tempDir + uploadedFile.getFileName());

		uploadedFile.write(file);
	}

	Object onUploadException(FileUploadException ex) {
		uploadErrorMessage = "Upload exception: " + ex.getMessage();
		return this;
	}

}