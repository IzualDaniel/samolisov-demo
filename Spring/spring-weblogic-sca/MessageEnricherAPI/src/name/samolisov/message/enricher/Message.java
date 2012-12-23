package name.samolisov.message.enricher;

public interface Message {

	public Long getId();
	
	public String getType();
	
	public String getBody();
}
