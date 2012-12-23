package name.samolisov.message.enricher;

public class MessageEnrichException extends Exception {
	
	private static final long serialVersionUID = 5055515259317657398L;

	public MessageEnrichException(String message) {
		super(message);
	}
	
	public MessageEnrichException(String message, Exception ex) {
		super(message, ex);
	}

}
