package name.samolisov.message.processor;

public class MessageProcessingException extends Exception {

	private static final long serialVersionUID = 423150471128584919L;

	public MessageProcessingException(String message) {
		super(message);
	}
	
	public MessageProcessingException(String message, Exception e) {
		super(message, e);
	}
}
