package name.samolisov.message.processor;

public interface MessageProcessorService {

	public void process(Long id) throws MessageProcessingException;
}
