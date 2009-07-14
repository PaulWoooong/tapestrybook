package de.t5book.pages;

import org.apache.tapestry5.util.TextStreamResponse;

public class TextStream {
    Object onAction(){
        String text = "<html><body>Success!</body></html>";
        return new TextStreamResponse("text/html", text);
    }
}
